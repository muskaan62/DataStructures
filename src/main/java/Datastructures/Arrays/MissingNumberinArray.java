package Datastructures.Arrays;

import java.util.HashMap;

//You are given an array nums containing n distinct numbers taken from the range 0 to n.
//Return the only number missing from the array.
//Input:
//nums = [3, 0, 1]
//Output:2
public class MissingNumberinArray {
    public static void main(String[] args) {
        int[] arr = {1,7,6,5,4,2}; // missing number is 4
        System.out.println("Missing number in array: " + findMissingNumber(arr));
        System.out.println("Missing number in array using XOR: " + findMissingNumber2(arr));
        System.out.println("Missing number in array using HashMap: " + findMissingNubmer3(arr));
    }

    // using brute force approach
    public static int findMissingNumber(int[] arr) {
       int n=0;
       int sum = 0;
       for (int i=0;i<=arr.length-1;i++) {
          sum = sum + arr[i];
       }
       for (int i=1;i<=arr.length+1;i++) {
          n = n + i; // sum of first n natural numbers
         }
       return n-sum;
    }

    // using XOR approach
    public static int findMissingNumber2(int[] arr) {
        int n = 0;
        for (int i=0;i<=arr.length+1;i++) {
            n ^= i; // XOR of all numbers from 1 to n
        }
        for (int i = 0; i < arr.length; i++) {
            n ^= arr[i]; // XOR all elements in the array
        }
       return n;
    }

    // using HashMap
    public static int findMissingNubmer3(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i=0;i<=arr.length-1;i++) {
            map.put(arr[i], true); // store all elements in the map
        }
        for (int i=1;i<=arr.length;i++) {
            if (!map.containsKey(i)) { // check if the number is not in the map
                return i; // return the missing number
            }
        }
        return -1;
    }
}
