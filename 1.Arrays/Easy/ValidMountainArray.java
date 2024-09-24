/* 
Problem: Valid Mountain Array

Given an array of integers, check if it's a valid mountain array.
A valid mountain array must:
1. Have at least 3 elements.
2. Have a peak element where the elements strictly increase before the peak, and strictly decrease after it.

Input:
- An array of integers with length >= 3.

Output:
- Return true if the array is a valid mountain array, otherwise false.

Brute Force Approach:
1. Find the peak by traversing the array.
2. Verify that elements before the peak strictly increase and elements after strictly decrease.
Time Complexity: O(n)

Optimal Approach:
1. Traverse the array once, first to find the peak and then to check the increasing and decreasing sequences.
Time Complexity: O(n)
*/
public class ValidMountainArray {

    // Brute Force Approach (Explanatory for better understanding)
    public static boolean validMountainBruteForce(int[] arr) {
        if (arr.length < 3) return false;
        
        int peak = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                peak = i;
            } else {
                break;
            }
        }
        
        if (peak == 0 || peak == arr.length - 1) return false;
        
        for (int i = peak + 1; i < arr.length; i++) {
            if (arr[i] >= arr[i - 1]) return false;
        }
        
        return true;
    }

    // Optimal Approach
    public static boolean validMountainOptimal(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        
        int i = 0;
        // Ascend
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        // Peak can't be the first or the last element
        if (i == 0 || i == n - 1) return false;
        
        // Descend
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }
        
        return i == n - 1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 1};
        
        // Brute Force Approach
        System.out.println("Brute Force: " + validMountainBruteForce(arr));

        // Optimal Approach
        System.out.println("Optimal: " + validMountainOptimal(arr));
    }
}
