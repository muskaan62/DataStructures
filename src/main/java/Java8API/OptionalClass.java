package Java8API;

import java.util.Optional;

public class OptionalClass {
    public static void main(String args[]) {
      Optional<String> op1 = Optional.ofNullable(getName());
      op1.ifPresent(name -> System.out.println("name is present " + name));
      op1.ifPresentOrElse(name -> System.out.println("name is present " + name),
              () -> System.out.println("value is not present")
      );
    //  op1.orElseThrow(()-> new RuntimeException("Value is not present"));
      op1.orElseGet(() -> "Default Name");
      op1.map(name -> "Hello, " + name);
      op1.filter(name -> name.length() > 3)
              .ifPresentOrElse(name -> System.out.println("Filtered name: " + name),
                      ()->System.out.println("xyz"));
    }

    public static String getName() {
        return "xyz";
    }
}
