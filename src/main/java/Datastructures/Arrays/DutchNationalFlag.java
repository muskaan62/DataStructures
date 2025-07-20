package Datastructures.Arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 0, 1, 2};
        System.out.println("Original Array:");
        printArray(arr);
        sortDutchNationalFlag(arr);
        System.out.println("Sorted Array:");
        printArray(arr);
    }
    public static void printArray(int[] arr) {
        for (int i=0;i<arr.length-1;i++) {
            System.out.print(arr[i]+",");
        }
        System.out.println();
    }
    public static void sortDutchNationalFlag(int[] arr) {
        int track = 0, low =0,high = arr.length-1;
        while (low<=high) {
            if (arr[low] == 0) {
                swap(arr, low, track);
                low++;
                track++;
            } else if (arr[low] == 1) {
                low++;
            } else {
               swap (arr, low, high);
               high--;
            }
        }
    }
    public static void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
