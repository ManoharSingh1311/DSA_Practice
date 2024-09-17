public class BuySellStockBruteForce
 {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;

        // Try every pair of buy and sell days
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int profit = prices[j] - prices[i]; // Profit if bought on day i and sold on day j
                maxProfit = Math.max(maxProfit, profit); // Keep track of maximum profit
            }
        }

        return maxProfit; // Return the maximum profit found
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit (Brute Force): " + maxProfit(prices));
    }
}
//Time Complexity :O(N2)
//Space Complexity : O(1)