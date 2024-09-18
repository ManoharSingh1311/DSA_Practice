// The problem you're trying to solve is to find the length of the longest subarray with a sum equal to k. 
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    // Brute Force Approach
    public int[] longestSubarrayWithSumK_BruteForce(int[] arr, int n, int k) {
        int maxLength = 0;
        int[] result = new int[0];
        
        // Consider all subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                
                // If sum is equal to k, update maxLength and store the subarray
                if (sum == k) {
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        result = Arrays.copyOfRange(arr, i, j + 1);
                    }
                }
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {10, 5, 2, 7, 1, 9};
        int k1 = 15;
        System.out.println("Brute Force Result: " + Arrays.toString(sol.longestSubarrayWithSumK_BruteForce(arr1, arr1.length, k1))); 
    }
}


//Time Complexity :O(N2)