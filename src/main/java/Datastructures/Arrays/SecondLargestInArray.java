package Datastructures.Arrays;

//Given an array of integers nums, return the second largest distinct element in the array.
//
//If no such element exists (i.e., all elements are equal), return -1.
// Example 1:
//Input:
//nums = [3, 5, 2, 5, 1]
//Output: 3
//Explanation: Largest = 5, Second largest = 3
//Example 2:
//Input:
//nums = [10, 10, 10]
//Output: -1
//Explanation: All elements are equal → no second largest
public class SecondLargestInArray {
    public static void main(String[] args) {
        int[] arr = {5,5,5};
        System.out.println("second largest in single pass " + findSecondLargestInSinglePass(arr));
        sortArray(arr);
        for (int j=0;j<arr.length;j++) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
        System.out.println("second largest " + findSecondLargest(arr));
    }

    // Sort Array using bubble sort
    public static void sortArray(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            for (int j=i+1;j<arr.length;j++) {
                if (arr[i]>arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static int findSecondLargest(int[] arr) {
        if (arr[arr.length-1]==arr[arr.length-2]) {
            return -1;
        }
        return arr[arr.length-2];
    }

    // Single pass two variables
    public static int findSecondLargestInSinglePass(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i=0;i<=arr.length-1;i++) {
            if(arr[i]>max) {
                secondMax = max;
               max = arr[i];
            } else if (arr[i]>secondMax && arr[i]!=max) {
                secondMax = arr[i];
            }
        }
        if (secondMax == Integer.MIN_VALUE) {
            return -1;
        }
        return secondMax;
    }

}
