// Problem: Product of Array Except Self
/*

Problem : Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i]. The solution should be implemented without using division and in O(n) time.

*/
public class ProductOfArrayExceptSelf {

    // Brute Force Approach
    // Time Complexity: O(n^2), Space Complexity: O(1)
    public static int[] productExceptSelfBrute(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    result[i] *= nums[j];
                }
            }
        }
        return result;
    }

    // Optimal Approach: Left and Right Products
    // Time Complexity: O(n), Space Complexity: O(1) (excluding the result array)
    public static int[] productExceptSelfOptimal(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Left product pass
        int leftProduct = 1;
        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // Right product pass
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println("Product Except Self (Brute): " + Arrays.toString(productExceptSelfBrute(nums)));
        System.out.println("Product Except Self (Optimal): " + Arrays.toString(productExceptSelfOptimal(nums)));
    }
}
