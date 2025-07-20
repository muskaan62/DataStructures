package Datastructures.Arrays;

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
}
