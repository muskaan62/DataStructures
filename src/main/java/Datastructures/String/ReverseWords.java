package Datastructures.String;


//Given a string, reverse the entire string, keeping the characters and spaces in their original positions.
//Example Input:
//"Hello World!"
//Example Output:
//"!dlroW olleH"
//Possible Techniques:
//String reversal using StringBuilder
//In-place character swapping using two-pointer.

import java.util.Stack;

public class ReverseWords {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println("Original String: " + str);
        System.out.println("Reversed each  Word in a String: " + reverseWords(str));
        System.out.println("Reversed words in a String: " + reverseStrin(str));
        System.out.println("Reversed words in a String and reversed each word: " + reverseWordsAndReverseEachWord(str));
        System.out.println("Reversed words in a String using stack: " + reversewordsusingStack(str));
    }

    // Function to reverse each words in a string
    public static String reverseWords(String str) {
        String reverseStr = "";
        String[] words = str.split(" ");
        for (String word : words) {
            String rev = "";
            for (int i = word.length() - 1; i >= 0; i--) {
                rev = rev + word.charAt(i);
            }
            reverseStr = reverseStr + rev + " ";
        }
        return reverseStr;
    }

    // Function to reverse  words in a sentence
    public static String reverseStrin(String str) {
        String[] words = str.split(" ");
        String reverse = "";
        for (int i = words.length - 1; i >= 0; i--) {
            reverse = reverse + words[i] + " ";
        }
        return reverse;
    }


    // Function to reverse words in a sentence and reverse each word
    public static String reverseWordsAndReverseEachWord(String str) {
        String reverseSentence = "";
        String[] words = str.split(" ");
        for (int i=words.length-1;i>=0;i--) {
            String rev = "";
            String word = words[i];
            for (int j= word.length()-1;j>=0;j--) {
                rev = rev + word.charAt(j);
            }
            reverseSentence = reverseSentence + rev + " ";
        }
        return reverseSentence;
    }

    public static String reversewordsusingStack(String str) {
        Stack<String> stack = new Stack<>();
        String[] words = str.split(" ");
        for (String word : words) {
            stack.push(word);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop()).append(" ");
        }
        return reversed.toString();
    }
}
