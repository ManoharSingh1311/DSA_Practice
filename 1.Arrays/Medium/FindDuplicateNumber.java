// Problem: Find the Duplicate Number
import java.util.Arrays;
import java.util.*;
/*
Problem : Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive, there is exactly one duplicate number in the array. Find the duplicate number.

*/
public class FindDuplicateNumber {

    // Brute Force Approach: Sorting
    // Time Complexity: O(n log n), Space Complexity: O(1)
    public static int findDuplicateBrute(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    // Optimal Approach: Floyd's Tortoise and Hare (Cycle Detection)
    // Time Complexity: O(n), Space Complexity: O(1)
    public static int findDuplicateOptimal(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] numsWithDup = {1, 3, 4, 2, 2};
        System.out.println("Duplicate (Brute): " + findDuplicateBrute(numsWithDup));
        System.out.println("Duplicate (Optimal): " + findDuplicateOptimal(numsWithDup));
    }
}
