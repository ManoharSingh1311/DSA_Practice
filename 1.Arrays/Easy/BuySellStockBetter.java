public class BuySellStockBetter {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[] maxSellPrice = new int[n];
        maxSellPrice[n - 1] = prices[n - 1];

        // Fill the maxSellPrice array with the max selling prices possible after each day
        for (int i = n - 2; i >= 0; i--) {
            maxSellPrice[i] = Math.max(maxSellPrice[i + 1], prices[i]);
        }

        int maxProfit = 0;

        // Iterate through prices to calculate the max profit
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, maxSellPrice[i] - prices[i]);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit (Better): " + maxProfit(prices));
    }
}
//Time Complexity :O(N)
//Space Complexity : O(N)