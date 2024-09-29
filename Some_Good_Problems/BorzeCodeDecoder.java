/*
This program decodes a Borze code string into its ternary representation.

Borze Code Mapping:
- '.' corresponds to '0'
- '-.' corresponds to '1'
- '--' corresponds to '2'

Steps:
1. Read the input string representing Borze code.
2. Iterate through the string:
   - If '.' is found, append '0' to the result.
   - If '-.' is found, append '1' to the result.
   - If '--' is found, append '2' to the result.
3. Output the decoded ternary number.
*/

import java.util.Scanner;

public class BorzeCodeDecoder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(); // Input Borze code
        StringBuilder strnum = new StringBuilder();
        int n = s.length();
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '.') {
                strnum.append('0');
                i += 1;
            } else if (s.charAt(i) == '-' && i + 1 < n && s.charAt(i + 1) == '.') {
                strnum.append('1');
                i += 2;
            } else {
                strnum.append('2');
                i += 2;
            }
        }

        System.out.println(strnum.toString()); // Output decoded number
        sc.close();
    }
}
