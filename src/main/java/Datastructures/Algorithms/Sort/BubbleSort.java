package Datastructures.Algorithms.Sort;

//Implement the Bubble Sort algorithm to sort an array of integers in ascending order.4
//The Bubble Sort algorithm compares adjacent elements in the array and swaps them if they are in the wrong order.
// This process is repeated until the entire array is sorted.
// Example:
//Input:
//nums = [5, 2, 9, 1, 5, 6]
//Output:
//[1, 2, 5, 5, 6, 9]
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};
        System.out.println("Array before sorting:");
        printArray(arr);
        bubbleSort(arr);
        System.out.println("Array after sorting:");
        printArray(arr);
        System.out.println("Array sorted in descending order:");
        bubbleSortDesc(arr);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    // sort in asscending order
    public static void bubbleSort(int[] arr) {
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

    public static void bubbleSortDesc(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
