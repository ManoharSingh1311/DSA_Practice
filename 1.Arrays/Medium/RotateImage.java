/*
 1. Rotate Image
Problem Description:
Given an n x n 2D matrix, rotate the matrix by 90 degrees (clockwise).

Naive Approach:
Idea:
Create a new matrix and copy elements from the original matrix by mapping them to their rotated positions.

Time Complexity: O(n²), since we need to iterate through every element in the matrix.
Space Complexity: O(n²), due to the creation of an additional matrix.
Better Approach:
Idea:
First, transpose the matrix (convert rows into columns) and then reverse each row. This effectively rotates the matrix by 90 degrees.

Time Complexity: O(n²), for both the transpose and row reversal.
Space Complexity: O(1), as no additional space is required beyond the matrix itself.
Optimal Approach:
Idea:
Rotate the matrix by moving elements layer by layer. Swap four corresponding cells in place (top → right → bottom → left → top).

Time Complexity: O(n²), as we process each element once.
Space Complexity: O(1), since we only modify the matrix in place.


 */
public class RotateImage {

    // Naive Approach: Create a new matrix
    public static int[][] rotateImageNaive(int[][] matrix) {
        int n = matrix.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - 1 - i] = matrix[i][j];  // Move elements to their rotated positions
            }
        }

        return result;  // Return the new rotated matrix
    }

    // Better Approach: Transpose and reverse rows
    public static void rotateImageBetter(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix (swap rows and columns)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    // Optimal Approach: Rotate in-place layer by layer
    public static void rotateImageOptimal(int[][] matrix) {
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                // Save top
                int top = matrix[first][i];

                // Move left to top
                matrix[first][i] = matrix[last - offset][first];

                // Move bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];

                // Move right to bottom
                matrix[last][last - offset] = matrix[i][last];

                // Move top to right
                matrix[i][last] = top;
            }
        }
    }

    // Main function to test all approaches
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Naive Approach
        int[][] resultNaive = rotateImageNaive(matrix);
        System.out.println("Rotated Matrix (Naive): " + Arrays.deepToString(resultNaive));

        // Better Approach
        rotateImageBetter(matrix);
        System.out.println("Rotated Matrix (Better): " + Arrays.deepToString(matrix));

        // Optimal Approach
        rotateImageOptimal(matrix);
        System.out.println("Rotated Matrix (Optimal): " + Arrays.deepToString(matrix));
    }
}
