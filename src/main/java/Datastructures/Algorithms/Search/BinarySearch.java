package Datastructures.Algorithms.Search;

//You are given a sorted array of n integers and a target value x.
// Your task is to write a function that returns the index of x in the array using binary search. If x is not present, return -1.
//Example:
//Input: arr = [1, 3, 5, 7, 9, 11], target = 7
//Output: 3
//Input: arr = [1, 3, 5, 7, 9, 11], target = 6
//Output: -1
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 8, 7, 9, 11};
        int target = 9;
        System.out.println("Binary Search using brute force approach: " + binarySearch(arr, target));
        System.out.println("Binary Search using recursion: " + find(arr, target, 0, arr.length - 1));
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int find(int[] arr, int target, int low, int high) {
        if (low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return find(arr, target, mid + 1, high);
        } else {
            return find(arr, target, low, mid - 1);
        }
    }
}
