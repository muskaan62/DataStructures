package Datastructures.String;

public class PalindromeString {
    public static void main(String[] args) {
        String str = "abbba";
        System.out.println("Is the string \"" + str + "\" a palindrome? " + isPalindrome(str));
        System.out.println("Is the string \"" + str + "\" a palindrome using two pointer approach? " + isPalindrome2(str));
        String palindrome = "A man, a plan, a canal: Panama";
        String cleanString = palindrome.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println("Is the string \"" + palindrome + "\" a palindrome? "
                + isPalindrome(cleanString));
        System.out.println("Is the string \"" + palindrome + "\" a palindrome using two pointer approach? "
                + isPalindrome2(cleanString));
        String palindrome1 = "Race a car";
        String cleanString1 = palindrome1.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println("Is the string \"" + palindrome1 + "\" a palindrome? "
                + isPalindrome(cleanString1));
        System.out.println("Is the string \"" + palindrome1 + "\" a palindrome using two pointer approach? "
                + isPalindrome2(cleanString1));


        // using recursion
        System.out.println("Is the string \"" + str + "\" a palindrome using recursion? " + isPalindrome3(str, 0, str.length() - 1));

    }


    // using brute force approach
    public static boolean isPalindrome(String str) {
        String rev = "";
        for (int i =str.length()-1; i >=0; i--) {
            rev = rev + str.charAt(i);
        }
        System.out.println("reverse string is: " + rev);
        return str.equals(rev);
    }


    // Two pointer approach
    public static boolean isPalindrome2(String str) {
        int left =0;
        int right = str.length()-1;
        while (left<=right) {
            if(str.charAt(left)!=str.charAt(right))
                return false;
            else  {
                left++;
                right--;
            }
        }
        return true;
    }

    // using recursion
    public static boolean isPalindrome3(String str, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        } else {
            return isPalindrome3(str, left + 1, right - 1);
        }
    }
}
