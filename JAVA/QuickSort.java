import java.util.*;
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {23, 56, 21, 34, 56, 78};

        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int start = low;
        int end = high;
        int mid = start + (end - start) / 2;
        int pivot = nums[mid]; // Simplified pivot selection

        while (start <= end) {
            while (nums[start] < pivot) {
                start++;
            }
            while (nums[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        // Now pivot is at correct index, sort the two halves
        sort(nums, low, end);
        sort(nums, start, high);
    }
}


