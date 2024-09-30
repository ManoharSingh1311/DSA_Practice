/*
 Problem Description:
Sort an array containing only 0, 1, and 2 without using any built-in sort function.

Brute Force Approach:
Idea: Count the occurrences of 0, 1, and 2, then rewrite the array based on the count.
Time Complexity: O(n) + O(n) = O(n) (two passes over the array).


Better/Optimal Approach:
Idea: Use the Dutch National Flag Algorithm to sort in a single pass.
Time Complexity: O(n) (single pass).

 */
import java.util.*;

public class SortingProblems {

    // Brute Force Approach for Sort Colors
    public static void sortColorsBrute(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }
        int index = 0;
        while (count0-- > 0) nums[index++] = 0;
        while (count1-- > 0) nums[index++] = 1;
        while (count2-- > 0) nums[index++] = 2;
    }

    // Optimal Approach for Sort Colors (Dutch National Flag Algorithm)
    public static void sortColorsOptimal(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low++, mid++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Main function to test Sort Colors
    public static void main(String[] args) {
        int[] colors = {2, 0, 2, 1, 1, 0};
        System.out.println("Original Array: " + Arrays.toString(colors));
        
        // Brute force approach
        sortColorsBrute(colors);
        System.out.println("Sorted by Brute: " + Arrays.toString(colors));

        // Resetting the array
        colors = new int[]{2, 0, 2, 1, 1, 0};
        
        // Optimal approach
        sortColorsOptimal(colors);
        System.out.println("Sorted by Optimal: " + Arrays.toString(colors));
    }
}
