import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // 1. Brute Force Approach
    public static List<List<Integer>> threeSumBruteForce(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        if (!result.contains(triplet)) {
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }

    // 2. Optimal Approach (Two-Pointer Technique)
    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sorting the array

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // Skip duplicates
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;  // Skip duplicates
                    while (left < right && nums[right] == nums[right + 1]) right--;  // Skip duplicates
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        // Brute Force Call
        System.out.println("Brute Force 3Sum: " + threeSumBruteForce(nums));

        // Optimal Call
        System.out.println("Optimal 3Sum: " + threeSumOptimal(nums));
    }
}
