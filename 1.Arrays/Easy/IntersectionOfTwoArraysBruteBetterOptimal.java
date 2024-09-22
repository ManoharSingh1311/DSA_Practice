/* 
Problem: Intersection of Two Arrays

Given two integer arrays, find their intersection. The intersection consists of elements present in both arrays.

Input:
- Two arrays of integers.

Output:
- A new array of the intersecting elements.

Brute Force Approach:
1. For each element in the first array, check if it is present in the second array.
2. If present, add it to the result.
Time Complexity: O(n * m) where n and m are the lengths of the arrays.

Better Approach:
1. Sort both arrays, and use two pointers to find common elements.
Time Complexity: O(n log n + m log m) due to sorting.

Optimal Approach:
1. Use a HashSet to store elements from the first array, and check for matches in the second array.
Time Complexity: O(n + m) with O(n) extra space for the HashSet.
*/

import java.util.*;

public class IntersectionOfTwoArraysBruteBetterOptimal {

    // Brute Force Approach
    public static List<Integer> intersectionBruteForce(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2 && !result.contains(num1)) {
                    result.add(num1);
                }
            }
        }
        return result;
    }

    // Better Approach: Sorting + Two Pointers
    public static List<Integer> intersectionTwoPointers(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (result.isEmpty() || result.get(result.size() - 1) != nums1[i]) {
                    result.add(nums1[i]);
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    // Optimal Approach: Using HashSet
    public static List<Integer> intersectionHashSet(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                resultSet.add(num);
            }
        }
        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        // Brute Force Approach
        System.out.println("Brute Force: " + intersectionBruteForce(nums1, nums2));

        // Better Approach: Sorting + Two Pointers
        System.out.println("Two Pointers: " + intersectionTwoPointers(nums1, nums2));

        // Optimal Approach: Using HashSet
        System.out.println("HashSet: " + intersectionHashSet(nums1, nums2));
    }
}
