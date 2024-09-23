/*
Problem: Equal Elements

Given an array of size N, in one operation, you can select indices i and j (i ≠ j) and set A[i] = A[j]. 
The task is to determine the minimum number of operations required to make all elements in the array equal.

Input:
- The first line contains an integer T (1 ≤ T ≤ 1000), the number of test cases.
- For each test case:
  - The first line contains an integer N (1 ≤ N ≤ 2 * 10^5), the size of the array.
  - The second line contains N space-separated integers, representing the elements of the array A.

Output:
- For each test case, print the minimum number of operations required to make all elements equal.

Approach:
1. For each test case, read the input values for N and the array A.
2. Count the frequency of each distinct element in the array using a HashMap.
3. Find the element with the maximum frequency (since it requires the fewest operations to make all elements equal to the most frequent element).
4. The minimum number of operations required is N - (maximum frequency), because we need to make all other elements equal to this most frequent element.
5. Print the result for each test case.

Examples:

Input:
3
3
1 2 3
4
2 2 3 1
4
3 1 2 4

Output:
2
2
3

Explanation:
- In the first test case, we need 2 operations to make all elements equal.
- In the second test case, 2 operations are needed.
- In the third test case, 3 operations are needed.
*/

import java.util.*;

public class EqualElements {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Read the number of test cases
        
        while(T-- > 0) {
            int n = sc.nextInt(); // Read the size of the array
            int arr[] = new int[n]; // Initialize the array
            
            // Fill the array with input values
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            // Create a HashMap to store the frequency of each element
            HashMap<Integer, Integer> fmap = new HashMap<>();
            
            // Populate the frequency map
            for (int i = 0; i < n; i++) {
                fmap.put(arr[i], fmap.getOrDefault(arr[i], 0) + 1);
            }
            
            int maxFreq = 0; // Variable to keep track of the maximum frequency of any element
            
            // Iterate over the frequency map to find the maximum frequency
            for (int freq : fmap.values()) {
                if (freq > maxFreq) {
                    maxFreq = freq;
                }
            }
            
            // The minimum number of operations is total elements - maximum frequency
            int minOperations = n - maxFreq;
            System.out.println(minOperations); // Print the result
        }
        
        sc.close(); // Close the scanner
    }
}
