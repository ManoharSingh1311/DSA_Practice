/*
 Problem Description:
Return all elements of a matrix in spiral order.

Brute Force Approach:
Idea: Use a visited matrix and simulate the movement in a spiral, checking for boundaries.
Time Complexity: O(m * n), where m is the number of rows and n is the number of columns.

Optimal Approach:
Idea: Use boundary markers for the top, bottom, left, and right, and keep adjusting them as you move in a spiral.
Time Complexity: O(m * n), as every element is processed once.

 */
import java.util.*;
import java.lang.*;
import java.io.*;

public class SpiralMatrix {

    // Brute Force Approach for Spiral Matrix
    public static List<Integer> spiralOrderBrute(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[] dr = {0, 1, 0, -1};  // Directions for rows
        int[] dc = {1, 0, -1, 0};  // Directions for columns
        int r = 0, c = 0, di = 0;  // Initial row, column, and direction

        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            result.add(matrix[r][c]);
            visited[r][c] = true;
            int nr = r + dr[di];
            int nc = c + dc[di];

            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length && !visited[nr][nc]) {
                r = nr;
                c = nc;
            } else {
                di = (di + 1) % 4;
                r = r + dr[di];
                c = c + dc[di];
            }
        }

        return result;
    }

    // Optimal Approach for Spiral Matrix
    public static List<Integer> spiralOrderOptimal(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) result.add(matrix[top][i]);
            top++;

            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) result.add(matrix[bottom][i]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }

        return result;
    }

    // Main function to test Spiral Matrix
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Brute force approach
        List<Integer> resultBrute = spiralOrderBrute(matrix);
        System.out.println("Spiral order (Brute): " + resultBrute);

        // Optimal approach
        List<Integer> resultOptimal = spiralOrderOptimal(matrix);
        System.out.println("Spiral order (Optimal): " + resultOptimal);
    }
}
