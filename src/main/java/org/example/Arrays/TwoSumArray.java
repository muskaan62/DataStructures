package org.example.Arrays;

public class TwoSumArray {
    public static void main(String[] args) {
        int[] arr = {5,3,4,2,1};
        int target = 6;
        System.out.println("Two Sum using brute force approach: ");
        printArray(twoSum(arr,target));
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
}
