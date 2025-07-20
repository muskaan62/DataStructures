package Datastructures.String;


//Problem Statement:
//Given a string, reverse each word in the sentence but keep the word order intact.
//Example Input:
//"Let's do this"
//Example Output:
//"s'teL od siht"
//Possible Techniques:
//1.Split the string into words, reverse each word individually.
//2.Use StringBuilder to reverse each word.
//3.In-place character swapping for each word
public class ReverseWordsinSentence {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println("Original String: " + str);
        System.out.println("Reversed each Word in a String: " + reverseWordsSentence(str));
        System.out.println("using string builder " + reverseWordsSentenceUsingBuilder(str));
    }

    public static String reverseWordsSentence(String str) {
        String rev = "";
        String[] words = str.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            String  word = words[i];
            String revWord = "";
            for (int j=word.length()-1;j>=0;j--) {
                revWord += word.charAt(j);
            }
            rev = rev + revWord + " ";
        }
        return rev;
    }

    // using string builder
    public static String reverseWordsSentenceUsingBuilder(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        return stringBuilder.reverse().toString();
    }
}
