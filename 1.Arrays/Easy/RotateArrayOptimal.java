/*
Problem 2: Rotate Array
Goal: Rotate the array by k steps to the right.
2.1 Brute Force Approach:
Idea: Rotate the array one step at a time, repeating k times.
TC: O(n * k)
SC: O(1)
2.2 Optimal Approach (Reverse Technique):
Idea: Reverse the entire array, reverse the first k elements, and then reverse the rest.
TC: O(n)
SC: O(1) – in-place.
*/

public class RotateArrayOptimal {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // In case k is greater than n
        
        reverse(nums, 0, n - 1);     // Step 1: Reverse the entire array
        reverse(nums, 0, k - 1);     // Step 2: Reverse the first k elements
        reverse(nums, k, n - 1);     // Step 3: Reverse the remaining n - k elements
    }
    
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
