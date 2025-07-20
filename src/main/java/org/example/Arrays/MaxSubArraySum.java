package org.example.Arrays;

//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum, and return its sum.
//Input:
//nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output:
// 6
//Explanation: The subarray [4, -1, 2, 1] has the largest sum = 6.
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum is: " + maxSubArraySum(arr));
        System.out.println("Maximum subarray sum using brute force is: " + maxSubArraySum2(arr));
    }

    // using kandanes algorithm
    public static int maxSubArraySum(int[] arr) {
        int currentSum=arr[0];
        int maxSum = arr[0];
        int start=0,end=0;
        for (int i=1;i<=arr.length-1;i++){
           if (currentSum < 0) {
                currentSum = arr[i]; // reset current sum if it is negative
               start = i;
            } else {
                currentSum += arr[i]; // add current element to current sum
            }
           if (currentSum > maxSum) {
               maxSum = currentSum;
               end = i;
           }
        }
        System.out.println("Max sum Subarray is from index " + start + " to " + end);
        return maxSum;
    }

    //using brute force
    public static int maxSubArraySum2(int[] arr) {
        int start=0,end=0;
        int maxSum=arr[0];
        for (int i=0;i<=arr.length-1;i++){
            int currentSum=0;
            for (int j=i;j<=arr.length-1;j++){
                currentSum += arr[j]; // add current element to current sum
                if (currentSum > maxSum) {
                    start = i;
                    end = j;
                    maxSum = currentSum;
                }
            }
        }
        System.out.println("Max sum Subarray is from index " + start + " to " + end);
        return maxSum;
    }
}
