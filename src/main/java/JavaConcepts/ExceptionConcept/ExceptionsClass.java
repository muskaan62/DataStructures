package JavaConcepts.ExceptionConcept;


class customException extends Exception {
    public customException(String message) {
        super(message);
    }
}
public class ExceptionsClass {
    public static void main(String args[]) {
      String i= getNum();
      System.out.println(i);
//      validate(-1);
      try {
          System.out.println("try without catch");
      } finally {
            System.out.println("finally block executed");
      }
//      if(true) {
//          try {
//              throw new customException("Custom Exception thrown");
//          }
//            catch (customException e) {
//              throw new RuntimeException("Runtime Exception: " + e.getMessage());
//          }
//      }
    }

    public static void validate(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    public static String getNum() {
        try {
            int num = 10/10;
            System.out.println("Inside try block, num = " + num);
            return "num";
        } catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception occurred: " + e.getMessage());
        }
        finally {
            System.out.println("Finally block executed");
            return "default";
        }
    }

}
