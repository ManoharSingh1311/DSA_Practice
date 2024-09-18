/* You are given an array arr[] of size N, containing both positive and negative integers. Your task is to find the smallest positive missing number from the array. The smallest positive number starts from 1.

Example 1:
Input:
N = 5
arr[] = {1, 2, 3, 4, 5}
Output:6

Example 2:
Input:
N = 5
arr[] = {0, -10, 1, 3, -20}
Output: 2
 */
public class smallestPositiveIntegerInArray {
    // Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size) {
        // Step 1: Replace negative numbers and numbers greater than size with size + 1
        for (int i = 0; i < size; i++) {
            if (arr[i] <= 0 || arr[i] > size) {
                arr[i] = size + 1;
            }
        }
        
        // Step 2: Mark the indices corresponding to the numbers present in the array
        for (int i = 0; i < size; i++) {
            int num = Math.abs(arr[i]);
            // If the number is within the range [1, size], mark its corresponding index
            if (num <= size) {
                arr[num - 1] = -Math.abs(arr[num - 1]);
            }
        }
        
        // Step 3: Find the first positive index, which indicates the missing number
        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        
        // If all numbers from 1 to size are present, return size + 1
        return size + 1;
    }
}
