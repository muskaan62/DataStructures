package Java8API;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class StreamAPi {
    public static void main(String[] args) {
        List<String> list = List.of("james","bobby","alice","charlie","david","jane", "ampy");
        System.out.println("Original List: " + list);

        // use of filter
        List<String> filterList = list.stream().filter(s->s.startsWith("j")).collect(Collectors.toList());
        System.out.println("Filtered List (starts with 'j'): " + filterList);
        List<String> filterList2 = list.stream().filter(name -> name.startsWith("a")).collect(Collectors.toList());
        System.out.println("Filtered List (starts with 'a'): " + filterList2);

        // use of collect and collectors
        // collect names into a list
        List<String> names = List.of("james","bobby","alice","charlie","david","jane", "ampy", "ampy");
        List<String> collectedNames = names.stream().collect(Collectors.toList());
        System.out.println("Collected Names: " + collectedNames);
        // collect names into a set
        Set<String> collectedSet = names.stream().collect(Collectors.toSet());
        System.out.println("Collected Set: " + collectedSet);

        // Join elements using delimeter
        String JoiningNames = names.stream().collect(Collectors.joining("-"));
        System.out.println("Joined Names with '-': " + JoiningNames);

        // join elements as a string
        String JoiningnamesasString = names.stream().collect(Collectors.joining());
        System.out.println("Joined Names as String: " + JoiningnamesasString);

        // group and count the frequency
        List<String> words = List.of("a", "bb", "ccc", "dd", "e");
        Map<Integer, List<String>> map = words.stream().collect(Collectors.groupingBy(key -> key.length()));
        System.out.println(map);
        Map<Integer, List<String>> revMap = words.stream().collect(Collectors.groupingBy(String::length,()-> new TreeMap<>(Comparator.reverseOrder()),
                Collectors.toList()));
        System.out.println(revMap);

        // Group by start of letter and its count
        Map<Character, Integer> map4 = names.stream().
                collect(Collectors.groupingBy(n -> n.charAt(0), Collectors.summingInt(n -> 1)));
        System.out.println(map4);

        // Group numbers by even or odd
        List<Integer> l = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> map1 = l.stream().collect(Collectors.groupingBy(n -> n%2 == 0));
        System.out.println(map1);

        // find even odd and compute sum
        Map<Boolean, Integer> sum = l.stream().collect(Collectors.groupingBy(n -> n%2==0, Collectors.summingInt(n->n)));
        System.out.println(sum);
        // group by first character

        Map<Character, List<String>> map2 = names.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(map2);

        // group number by number of digits
        List<Integer> numbers = List.of(1, 22, 333, 4444, 55555, 3333, 2222, 1111, 12345, 67890, 12, 0);
        Map<Integer, List<Integer>> map3 = numbers.stream().collect(Collectors.groupingBy(n -> n.toString().length()));
        System.out.println(map3);

        // From a list of strings, collect only non-empty and non-null strings.
        List<String> list1 = Arrays.asList("",null, "xyz", "abc", "", null);
        List<String> ml = list1.stream().filter(n -> n != null && !n.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List (not empty or null): " + ml);

        // filter function
       // From a list of integers, collect all even numbers.
        List<Integer> even = l.stream().filter(n->n%2==0).collect(Collectors.toList());
        System.out.println("Even Numbers: " + even);

        //From a list of numbers, collect only prime numbers.
        List<Integer> primeNumbers = l.stream().filter(StreamAPi::isPrime).collect(Collectors.toList());
        System.out.println("Prime Numbers: " + primeNumbers);

        // Map Based
        // Convert a list of strings to uppercase.
        List<String> empName = names.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
        System.out.println("Uppercase Names: " + empName);

        //Convert a list of strings to uppercase.
//        List<String> empName2 = names.stream().filter(n->n.charAt(0).toUpperCase()).collect(Collectors.toList());

        //From a list of integers, return a list of their squares.
        List<Integer> sqaure = l.stream().map(n->n*n)
                .collect(Collectors.toList());;
        System.out.println("Squares of Numbers: " + sqaure);

        // Find the sum of all integers in a list.
        List<Integer> numbersList = List.of(2,4,9,3,5,6);
        int SumOfNum = numbersList.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum of Numbers: " + SumOfNum);

        int sumOfNum2 = numbersList.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum of Numbers using mapToInt: " + sumOfNum2);

        // Find the product of all integers in a list.
        int product = numbersList.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Product of Numbers: " + product);

        // Find the maximum and minimum number in a list.
        Optional<Integer> max = numbersList.stream().max(Integer::compareTo);
        System.out.println("Maximum Number: " + max.orElse(null));
        Optional<Integer> min = numbersList.stream().min(Integer::compareTo);
        System.out.println("Minimum Number: " + min.orElse(null));

        //Given a list of strings, concatenate them into a single string (with space).
        String str = names.stream().collect(Collectors.joining(" "));
        System.out.println("Concatenated String: " + str);

//        Find the maximum element from a list using reduce.
        Optional<Integer> max1 = numbersList.stream().reduce((a, b)-> (a>b? a : b));
        System.out.println("Maximum Element using reduce: " + max1);
        // Count the number of elements in a list using reduce.
        int count = numbersList.stream().map(e->1).reduce(0, Integer::sum);
        System.out.println("Count of Elements using reduce: " + count);

        //From a list of integers, filter even numbers, square them, and sum the result.
        int num = numbersList.stream().filter(n->n%2==0).map(n->n*n)
                .reduce(0,Integer::sum);
        System.out.println("Sum of Squares of Even Numbers: " + num);

        //From a list of words, remove nulls and blanks, convert to uppercase, and join with commas.
        String capsword = list1.stream().filter(n->n!=null && !n.isEmpty()).map(n->n.toUpperCase())
                .collect(Collectors.joining(","));
        System.out.println("Processed Words: " + capsword);
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
