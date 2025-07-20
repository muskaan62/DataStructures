package Datastructures.String;

//Given two strings, determine if they are anagrams of each other.
//Two strings are anagrams if they contain the exact same characters with the same frequency, but the order of the characters can be different.
//Example 1:
//Input:
//"listen", "silent"
//Output:
//true

import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println("Are the strings anagrams? " + areAnagrams(str1, str2));
        System.out.println("using array sort " + areAnagramsUsingArraySort(str1, str2));
        System.out.println("using HashMap " + areAnagramsUsingHashMap(str1, str2));
        System.out.println("using single HashMap " + areAnagramsUsingSingleHashMap(str1, str2));
    }

    // using brute force approach
    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String str1 = sortString(s1);
        String str2 = sortString(s2);
        return str1.equals(str2);
    }

    public static String sortString(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i <= chars.length - 1; i++) {
            for (int j = i + 1; j <= chars.length - 1; j++) {
                if (chars[i] > chars[j]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return new String(chars);
    }

    // using array sort
    public static boolean areAnagramsUsingArraySort(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    // using two HashMap
    public static boolean areAnagramsUsingHashMap(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i =0;i <= str1.length()-1;i++) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
        }
        return map1.equals(map2);
    }

    // using single HashMap
    public static boolean areAnagramsUsingSingleHashMap(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (int i=0;i<=str1.length()-1;i++) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i),0)+1);
            map1.put(str2.charAt(i), map1.getOrDefault(str2.charAt(i),0)-1);
        }
        for (int count : map1.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
