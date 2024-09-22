/* 
Problem: Single Number

Given an array of integers where every element appears twice except for one, 
find the element that appears only once.

Input:
- An array of integers with exactly one element appearing once, while every other appears twice.

Output:
- The element that appears only once.

Brute Force Approach:
1. For each element, count its occurrences in the array.
2. The element with a count of 1 is the answer.
Time Complexity: O(n^2)

Better Approach:
1. Use a HashMap to store the frequency of each element.
2. Iterate through the map to find the element that occurs once.
Time Complexity: O(n) with O(n) extra space.

Optimal Approach:
1. Use XOR. XOR of all elements gives the single element, as duplicates cancel each other.
Time Complexity: O(n) with O(1) extra space.
*/

import java.util.HashMap;

public class SingleNumberBruteBetterOptimal{

    // Brute Force Approach
    public static int singleNumberBruteForce(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) count++;
            }
            if (count == 1) return nums[i];
        }
        return -1; // should never reach here
    }

    // Better Approach using HashMap
    public static int singleNumberHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : map.keySet()) {
            if (map.get(num) == 1) return num;
        }
        return -1; // should never reach here
    }

    // Optimal Approach using XOR
    public static int singleNumberXOR(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        
        // Brute Force Approach
        System.out.println("Brute Force: " + singleNumberBruteForce(nums));

        // Better Approach using HashMap
        System.out.println("HashMap: " + singleNumberHashMap(nums));

        // Optimal Approach using XOR
        System.out.println("XOR: " + singleNumberXOR(nums));
    }
}
