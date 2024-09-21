/*Problem 1: Move Zeroes

Goal: Move all zeroes in the array to the end while maintaining the order of non-zero elements.

1.1 Brute Force Approach:
Idea: Create a new array, copy non-zero elements first, then append zeroes.
Time Complexity (TC): O(n)
Space Complexity (SC): O(n) – new array.

1.2 Optimal Approach (Two-Pointer Technique):
Idea: Use two pointers; shift non-zero elements to the front, then fill remaining positions with zeroes.
TC: O(n)
SC: O(1) – in-place.
*/
public class MoveZeroesBetter {
    public static void moveZeroes(int[] nums) {
        int index = 0; // Position to place the next non-zero element
        
        // Move non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        
        // Fill the rest of the array with zeros
        while (index < nums.length) {
            nums[index++] = 0;
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
