package Datastructures.Arrays;

//Given an integer array nums, move all 0s to the end of the array while maintaining the relative order of the non-zero elements.
//You must do this in-place without making a copy of the array.
//Example:
//Input:
//nums = [0, 1, 0, 3, 12]
//Output: [1, 3, 12, 0, 0]
public class MoveZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 0,5,6, 12};
        System.out.println("Move zeroes to end of array");
//        moveZeroes(arr);
//        printArray(arr);
        System.out.println("two pointer approach");
        printArray(twoPointerMoveZeroes(arr));
    }

    public static void printArray(int[] arr) {
        for (int i=0;i<=arr.length-1;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // using brute force approach
    public static void moveZeroes(int[] arr) {
        int n=arr.length;
        for (int i=0;i<=arr.length-1;i++) {
            if (arr[i]==0) {
                for (int j=i+1;j<=n-1;j++) {
                    if (arr[j]!=0) {
                        System.out.println(arr[j]);
                        System.out.println(arr[i]);
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    // using two pointer approach
    public static int[] twoPointerMoveZeroes(int[] arr) {
        int j = 0; // pointer for non-zero elements
       for (int i=0;i<=arr.length-1;i++) {
           if (arr[i]!=0) {
               System.out.println(arr[i]);
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               j++; // move the pointer for non-zero elements
           }
       }
        return arr;
    }

}
