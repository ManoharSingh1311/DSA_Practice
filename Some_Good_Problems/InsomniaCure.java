/*
Problem Summary:
A princess is counting dragons to help her fall asleep, but she imagines hurting the dragons in various ways.
- Every k-th dragon gets punched in the face.
- Every l-th dragon gets its tail caught in the door.
- Every m-th dragon gets its paws trampled by heels.
- Every n-th dragon is scared by the princess calling her mom.
Given the total number of dragons (d), the task is to calculate how many dragons suffer at least one type of damage.

Input:
- Five integers: k, l, m, n, and d, each in a separate line.
  Constraints: 1 ≤ k, l, m, n ≤ 10, 1 ≤ d ≤ 100000.

Output:
- Output the number of dragons that suffer any type of damage.

Example:
Input:
1
2
3
4
12
Output:
12
*/
import java.util.Scanner;

public class InsomniaCure {
    
    // Function to calculate LCM (Least Common Multiple)
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input values
        int k = sc.nextInt();
        int l = sc.nextInt();
        int m = sc.nextInt();
        int n = sc.nextInt();
        int d = sc.nextInt();
        
        int count = 0;
        
        // Special case: If any of k, l, m, or n is 1, all dragons are damaged
        if (k == 1 || l == 1 || m == 1 || n == 1) {
            System.out.println(d);
        } else {
            // Loop through all dragons from 1 to d
            for (int i = 1; i <= d; i++) {
                // If any dragon is divisible by k, l, m, or n, it is damaged
                if (i % k == 0 || i % l == 0 || i % m == 0 || i % n == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
        
        sc.close();
    }
}
