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
public class MaximumSubarray {

    // Brute Force Approach for Maximum Subarray
    public static int maxSubArrayBrute(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    // Optimal Approach for Maximum Subarray (Kadane's Algorithm)
    public static int maxSubArrayOptimal(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // Main function to test Maximum Subarray
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // Brute force approach
        int maxSumBrute = maxSubArrayBrute(nums);
        System.out.println("Max Subarray Sum (Brute): " + maxSumBrute);

        // Optimal approach
        int maxSumOptimal = maxSubArrayOptimal(nums);
        System.out.println("Max Subarray Sum (Optimal): " + maxSumOptimal);
    }
}
