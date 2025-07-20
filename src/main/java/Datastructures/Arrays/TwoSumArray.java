package Datastructures.Arrays;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to the target.
//You may assume that each input has exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
//📥 Example Input & Output
//Input: nums = [2, 7, 11, 15], target = 9
//Output: [0, 1] // because nums[0] + nums[1] == 2 + 7 == 9
public class TwoSumArray {
    public static void main(String[] args) {
        int[] arr = {3,5,6,1,2};
        int target = 3;
        System.out.println("Two Sum using brute force approach: ");
        printArray(twoSum(arr,target));
        System.out.println("Two Sum using hashmap one pass approach: ");
        printArray(twoSum2(arr, target));
    }

    public static void printArray(int[] arr) {
        for (int i=0;i<=arr.length-1;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    //using brute force
    public static int[] twoSum(int[] arr, int target) {
        int i=0;
        int j=0;
        for (i=0;i<=arr.length-1;i++) {
            for (j=i+1;j<=arr.length-1;j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // use hashmap two pass
    public static int[] twoSum2(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
       for (int i=0;i<=arr.length-1;i++) {
           int complement = target - arr[i]; // find the complement
           if (map.containsKey(complement)) { // check if complement exists and is not the same index
               return new int[]{map.get(complement), i}; // return the indices of the two numbers
           }
            map.put(arr[i], i); // store the element and its index in the map
        }
       return null;
    }
}
