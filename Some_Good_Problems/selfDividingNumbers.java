/*
Problem Statement:
A Ninja wants to collect all possible self-dividing numbers from a given range of numbers.

A self-dividing number is a number that is divisible by every digit it contains.

For example:
128 is a self-dividing number because:
    128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
    
Given two numbers 'LOWER' and 'UPPER', the task is to find all possible self-dividing numbers in the range from 'LOWER' to 'UPPER'.

Important Notes:
1. A self-dividing number should not contain the digit zero.
2. A number must be divisible by all of its non-zero digits to qualify as self-dividing.

Input:
- The first line contains an integer T, the number of test cases.
- For each test case, there are two integers 'LOWER' and 'UPPER', which define the range.

Output:
- For each test case, print all the self-dividing numbers in the given range on a single line, separated by spaces.

Example:
Input:
2
10 30
15 45

Output:
11 12 15 22 24
15 22 24 33 36 44

Explanation:
Test Case 1: For the range 10 to 30, the self-dividing numbers are: [11, 12, 15, 22, 24].
Test Case 2: For the range 15 to 45, the self-dividing numbers are: [15, 22, 24, 33, 36, 44].

*/
import java.util.ArrayList;
import java.util.Scanner;

public class selfDividingNumbers {

    // Method to find all self-dividing numbers between 'lower' and 'upper' range
    public static ArrayList<Integer> findAllSelfDividingNumbers(int lower, int upper) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = lower; i <= upper; i++) {
            if (isSelfDividing(i)) {
                result.add(i);  // Add the number if it's self-dividing
            }
        }
        return result;
    }

    // Method to check if a number is self-dividing
    public static boolean isSelfDividing(int num) {
        int temp = num; 
        while (temp != 0) {
            int rem = temp % 10; // Extract the last digit
            if (rem == 0 || num % rem != 0) {  // If digit is 0 or num is not divisible by the digit
                return false;  // Not self-dividing
            }
            temp /= 10;  // Remove the last digit
        }
        return true;  // The number is self-dividing
    }

    // Main method to handle input and output
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // Number of test cases

        while (t-- > 0) {
            int lower = sc.nextInt();  // Lower bound
            int upper = sc.nextInt();  // Upper bound

            // Find all self-dividing numbers in the given range
            ArrayList<Integer> result = findAllSelfDividingNumbers(lower, upper);

            // Print the result
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
    
}
