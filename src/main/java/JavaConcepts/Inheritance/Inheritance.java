package JavaConcepts.Inheritance;
class A {
    A() {
        System.out.println("Constructor of class A called");
    }
    public void print() {
        System.out.println("This is class A");
    }
}
class B extends A {
    @Override
    public void print() {
        System.out.println("This is class B");
    }
}

class C extends A {
    @Override
    public void print() {
        System.out.println("This is class C");
    }
}

//inner class
class Test {
    class Exam {
        public void display() {
            System.out.println("This is an inner class");
        }
    }
}
public class Inheritance {
    public static void main(String args[]) {
        Test t = new Test();
       Test.Exam e = new Test().new Exam();
        e.display();
        A a = new A();
        B b = new B();
        C c = new C();
        A a1 = new B();
        A c1 = new C();
//        B b1 = new A();
        a.print();
        b.print();
        c.print();
        a1.print();
        c1.print();

    }
}
