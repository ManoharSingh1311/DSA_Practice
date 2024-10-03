/*
 Find Minimum in Rotated Sorted Array
Problem Description:
Given a rotated sorted array, find the minimum element.

Naive Approach:
Idea:
Iterate through the entire array and find the minimum value.

Time Complexity: O(n), since we have to scan the whole array.
Space Complexity: O(1), as no additional space is used.
Better Approach:
Idea:
Perform a modified binary search to find the pivot where the rotation happens. The minimum element is either the pivot or the next element after it.

Time Complexity: O(log n), using binary search.
Space Complexity: O(1), since no extra space is required.
Optimal Approach:
Idea:
Use a similar binary search technique as the Better Approach, but slightly optimize the comparison logic to handle cases where there are no duplicates and the array is strictly increasing.

Time Complexity: O(log n), as binary search reduces the search space by half.
Space Complexity: O(1), no additional space required.

*/
public class FindMinInRotatedSortedArray {

    // Naive Approach: Linear Search
    public static int findMinNaive(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    // Better Approach: Binary Search
    public static int findMinBetter(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If middle element is greater than the rightmost, the min is on the right side
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;  // Mid could be the minimum
            }
        }
        return nums[left];  // Left is pointing to the smallest element
    }

    // Optimal Approach: Simplified Binary Search
    public static int findMinOptimal(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Compare mid with the last element to decide which part to search
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;  // Shrink the search space
            }
        }

        return nums[left];  // The smallest element
    }

    // Main function to test all approaches
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        // Naive Approach
        int minNaive = findMinNaive(nums);
        System.out.println("Minimum Element (Naive): " + minNaive);

        // Better Approach
        int minBetter = findMinBetter(nums);
        System.out.println("Minimum Element (Better): " + minBetter);

        // Optimal Approach
        int minOptimal = findMinOptimal(nums);
        System.out.println("Minimum Element (Optimal): " + minOptimal);
    }
}
