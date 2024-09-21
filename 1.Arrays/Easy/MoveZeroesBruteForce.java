/*Problem 1: Move Zeroes

Goal: Move all zeroes in the array to the end while maintaining the order of non-zero elements.

1.1 Brute Force Approach:
Idea: Create a new array, copy non-zero elements first, then append zeroes.
Time Complexity (TC): O(n)
Space Complexity (SC): O(n) – new array.

1.2 Optimal Approach (Two-Pointer Technique):
Idea: Use two pointers; shift non-zero elements to the front, then fill remaining positions with zeroes.
TC: O(n)
SC: O(1) – in-place.*/
public class MoveZeroesBruteForce {
    public static void moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        
        // Fill result array with non-zero elements
        for (int num : nums) {
            if (num != 0) {
                result[index++] = num;
            }
        }
        
        // Copy result back to the original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
