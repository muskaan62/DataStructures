package Datastructures.Arrays;

//Given an array of integers nums, reverse the array in-place, so that the first element becomes the last, the second becomes second last, and so on.
//Example:
//Input:
//nums = [1, 2, 3, 4, 5]
//Output:
//[5, 4, 3, 2, 1]
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {5,7,9,2,8};
        System.out.println("Reverse array");
        int[] revArray = reverse(arr);
        printArray(revArray);
        System.out.println("Reverse array using two pointer approach");
        int[] revArrayTwoPointer = reverseTwoPinterArray(arr);
        printArray(revArrayTwoPointer);
        System.out.println("Reverse array using recursion");
        System.out.println("before array reversal");
        printArray(arr);
        reverseArrayRecursion(arr, 0, arr.length-1);
        System.out.println("after array reversal");
        printArray(arr);

    }
    public static void printArray(int[] arr) {
        for (int i=0;i<=arr.length-1;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    // using brute force approach
    public static int[] reverse(int[] arr){
        int n= arr.length;
        int[] result = new int[n];
        for (int i = 0;i<=n-1;i++) {
            result[i] = arr[n-1-i];
        }
        return result;
    }

    // using two pointer approach
    public static int[] reverseTwoPinterArray(int[] arr) {
        int n= arr.length;
        int left = 0;
        int right = n-1;
        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left ++;
            right --;
        }
        return arr;
    }

    // using Recursion
    public static void reverseArrayRecursion(int[] arr, int left, int right) {
        if (left<=right) {
            return ;
        }
        int temp = arr[left];
        arr[left]=arr[right];
        arr[right]=temp;
        reverseArrayRecursion(arr,left+1,right-1);
    }
}
