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

public class RotateArrayBruteForce {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // In case k is greater than n
        
        // Rotate the array k times
        for (int i = 0; i < k; i++) {
            rotateByOne(nums);
        }
    }
    
    private static void rotateByOne(int[] nums) {
        int last = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = last;
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
