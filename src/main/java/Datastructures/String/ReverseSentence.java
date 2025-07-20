package Datastructures.String;

//Given a string, reverse the order of words in the string. Words are separated by spaces.
//Example Input:
//"the sky is blue"
//Example Output:
//"blue is sky the"
//Possible Techniques:
//Split the string by spaces, reverse the array, then join them.
//Stack-based approach.
public class ReverseSentence {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println("Original String: " + str);
        System.out.println("Reversed each Word in a String: " + reverseWords(str));
        StringBuilder stringBuilder = new StringBuilder(str);
        System.out.println("Reversed words in a String using string builder: " + stringBuilder.reverse().toString());
    }

    public static String reverseWords(String str) {
        String[] words = str.split(" ");
        String rev = "";
        for (int i=words.length-1; i>=0; i--) {
            rev = rev + words[i] + " ";
        }
        return rev;
    }

}
