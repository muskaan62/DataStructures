package org.example.Arrays;
//
//Given an array of integers nums, find and return the difference between the maximum and minimum elements in the array.
//Input:
//nums = [3, 1, 7, 4, 9]
//Output:
//9,1
public class MinMaxArray {
    public static void main(String[] args) {
        int arr[] = {0,0,1,2};
        System.out.println("Find minimum and maximum in an array");
        printArray(findMinMAx(arr));
        System.out.println("Find minimum and maximum in an array using two pointer approach");
        printArray(findMinMaxTwoPointer(arr));

        System.out.println("Min Array using recursion " + findMin(arr, arr.length));
        System.out.println("Max Array using recursion " + findMax(arr, arr.length));
    }

    public static void printArray(int[] arr) {
        for (int i=0;i<=arr.length-1;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // using brute force approach
    public static int[] findMinMAx(int arr[]) {
        int min=arr[0];
        int max=arr[0];
        for (int i=0;i<=arr.length-1;i++) {
            if (arr[i]>=max) {
                max =arr[i];
            }
            if (arr[i]<=min) {
                min = arr[i];
            }
        }
        return new int[]{min,max};
    }

    // using two pointer approach
    public static int[] findMinMaxTwoPointer(int arr[]) {
       int left = 0;
       int right = arr.length-1;
       int min = arr[0];
       int max = arr [0];
       while (left<=right) {
           if (arr[left]<min) {
               min = arr[left];
           }
           if (arr[right]<min) {
               min = arr[right];
           }
           if (arr[left]>max) {
               max = arr[left];
           }
           if (arr[right]>max) {
               max = arr[right];
           }
           left++;
           right--;
       }
       return new int[]{min,max};
    }

    public static int findMin(int arr[], int n) {
        if (n==0)
            return arr[0];
        return Math.min(arr[n-1], findMin(arr, n-1));
    }

    public static int findMax(int arr[], int n) {
        if (n == 0)
            return arr[0];
        return Math.max(arr[n-1], findMax(arr, n-1));
    }
}
