package JavaConcepts.MultiThreading;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Thread1 extends Thread {
 @Override
    public void run() {
     System.out.println("Thread class");
 }
}

class Runnable1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable1 interface");
    }
}
public class MultiThreading {
    public static void main(String args[]) throws InterruptedException {
        Thread1 t1 = new Thread1();
        Runnable1 r1 = new Runnable1();
        Runnable r2 = () -> {
                System.out.println("Runnable2 interface");
        };
        t1.start();
        t1.setName("Thread1");
        t1.getName();
        t1.sleep(1000);
        t1.interrupt();
        t1.join();
        System.out.println("Thread name: " + t1.getName());
        r1.run();
        r2.run();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,5,60, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        executor.execute(() -> {
            System.out.println("Task 1 is running in thread: " + Thread.currentThread().getName());
        });
        executor.shutdown();

    }
}
