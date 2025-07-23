package JavaConcepts.MultiThreading;

import java.util.LinkedList;

public class ProducerConsumerProblem {
    private final LinkedList<Integer> l = new LinkedList<>();
    int capacity = 3;
    public synchronized void producer(int value) throws InterruptedException {
        while (l.size() == capacity) {
            wait();
        }
        System.out.println("Produced value " + value);
        l.add(value);
        notify();
    }

    public synchronized int consumer() throws InterruptedException {
        while (l.isEmpty()) {
            wait();
        }
        int value = l.removeFirst();
        System.out.println("Consumed value " + value);
        notify();
        return value;
    }

    public static void main(String args[]) {
        ProducerConsumerProblem bf = new ProducerConsumerProblem();
        Thread t1 = new Thread(()->
        {
            for (int i=1;i<=10;i++) {
                try {
                    bf.producer(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->
        {
            for (int i=1;i<=10;i++) {
                try {
                    bf.consumer();
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }

}
