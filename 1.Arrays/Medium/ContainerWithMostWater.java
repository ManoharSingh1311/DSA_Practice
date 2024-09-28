// Problem: Container With Most Water
/*
Problem 1: Container With Most Water
You are given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i are at (i, ai) and (i, 0). Find two lines that together with the x-axis forms a container, such that the container contains the most water.

*/
public class ContainerWithMostWater {

    // Brute Force Approach
    // Time Complexity: O(n^2), Space Complexity: O(1)
    public static int maxAreaBrute(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }

    // Optimal Approach: Two Pointers
    // Time Complexity: O(n), Space Complexity: O(1)
    public static int maxAreaOptimal(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area (Brute): " + maxAreaBrute(height));
        System.out.println("Max Area (Optimal): " + maxAreaOptimal(height));
    }
}
