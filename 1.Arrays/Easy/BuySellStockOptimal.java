 public class BuySellStockOptimal 
{
    public static int maxProfit(int[] prices) 
    {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Iterate through prices array
        for (int price : prices) {
            // Keep track of the minimum price encountered so far
            if (price < minPrice) {
                minPrice = price;
            } 
            // Calculate the profit if we were to sell at the current price
            else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        return maxProfit; // Return the maximum profit found
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit (Optimal): " + maxProfit(prices));
    }
}
//Time Complexity :O(N)
//Space Complexity : O(1)