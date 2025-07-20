package Datastructures.String;

import java.util.Stack;

//Given a string, reverse the string and return the result.
//Example Input:
//"hello"
//Example Output:
//"olleh"
//Possible Techniques:
//Two-pointer (in-place)
//Using StringBuilder
//Recursion
//using stack
public class ReverseString {
    public static void main(String[] args) {
        String str = "cam";
        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reverseString(str));
        System.out.println("Reversed String using two pointer approach: ");
        System.out.println(reverseStringTwoPointer(str));
        System.out.println("Using String Builder");
        System.out.println(reverseStringUsingBuilder("drama"));
        System.out.println("using recursion");
        System.out.println(reverseStringRecursion("camera"));
        System.out.println("using stack");
        System.out.println(reverseStringUsingStack("hello"));
    }

    // using brute force approach
    public static String reverseString(String str) {
        String reversedString = "";
        for (int i=str.length()-1; i>=0; i--) {
            reversedString = reversedString + str.charAt(i);
        }
        return reversedString;
    }

    // using two pointer approach
    public static String reverseStringTwoPointer(String str) {
        char[] charArray = str.toCharArray();
        int left =0;
        int right = charArray.length-1;
        while(left<right) {
            char temp = charArray[left];
            charArray[left++] = charArray[right];
            charArray[right--] = temp;
        }
        return new String(charArray);
    }

    // using String Builder
    public static String reverseStringUsingBuilder(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }

    // using recursion
    public static String reverseStringRecursion(String str) {
        if (str.isEmpty())
            return str;
        return reverseStringUsingBuilder(str.substring(1)) + str.charAt(0);
    }

    // using stack
    public static String reverseStringUsingStack(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i =0;i<=str.length()-1;i++) {
            stack.push(str.charAt(i));
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
