import java.util.HashMap;
import java.util.Arrays;

class Solution {
    // Optimal Approach
    public int[] longestSubarrayWithSumK_Optimal(int[] arr, int n, int k) {
        // HashMap to store (cumulative sum, index)
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        int startIndex = -1;
        int endIndex = -1;
        
        // Traverse the array
        for (int i = 0; i < n; i++) {
            sum += arr[i];  // Update the cumulative sum
            
            // If sum is equal to k, we found a subarray from index 0 to i
            if (sum == k) {
                maxLength = i + 1;
                startIndex = 0;
                endIndex = i;
            }
            
            // If (sum - k) is found in the map, a subarray with sum k exists
            if (map.containsKey(sum - k)) {
                int subarrayStart = map.get(sum - k) + 1;
                int subarrayLength = i - map.get(sum - k);
                
                if (subarrayLength > maxLength) {
                    maxLength = subarrayLength;
                    startIndex = subarrayStart;
                    endIndex = i;
                }
            }
            
            // Store the current cumulative sum in the map if not already present
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        // Return the longest subarray with sum k
        if (startIndex != -1 && endIndex != -1) {
            return Arrays.copyOfRange(arr, startIndex, endIndex + 1);
        }
        
        return new int[0];  // Return empty array if no subarray found
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr1 = {10, 5, 2, 7, 1, 9};
        int k1 = 15;
        System.out.println("Optimal Result: " + Arrays.toString(sol.longestSubarrayWithSumK_Optimal(arr1, arr1.length, k1))); // Output: [5, 2, 7, 1]
        
        int[] arr2 = {-1, 2, 3};
        int k2 = 6;
        System.out.println("Optimal Result: " + Arrays.toString(sol.longestSubarrayWithSumK_Optimal(arr2, arr2.length, k2))); // Output: []
    }
}
