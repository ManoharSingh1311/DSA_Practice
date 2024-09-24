/* 
Problem: Shuffle the Array

Given an array consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn], 
shuffle the array to become [x1,y1,x2,y2,...,xn,yn].

Input:
- An array of integers with 2n elements and an integer n representing the half of the array.

Output:
- Return a shuffled array as described.

Brute Force Approach:
1. Create a new array and alternately place elements from both halves of the original array.
Time Complexity: O(n)

Optimal Approach:
1. Traverse the array and rearrange it alternately in a single pass.
Time Complexity: O(n)

*/
public class ShuffleTheArray {

    // Brute Force Approach (Using extra array)
    public static int[] shuffleBruteForce(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }
        return result;
    }

    // Optimal Approach (In-place modification possible but keeping extra array for clarity)
    public static int[] shuffleOptimal(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;

        // Brute Force Approach
        int[] shuffledBrute = shuffleBruteForce(nums, n);
        System.out.println("Brute Force: " + java.util.Arrays.toString(shuffledBrute));

        // Optimal Approach
        int[] shuffledOptimal = shuffleOptimal(nums, n);
        System.out.println("Optimal: " + java.util.Arrays.toString(shuffledOptimal));
    }
}
