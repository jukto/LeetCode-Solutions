class Solution {
    public int maxProfit(int[] prices, int fee) {
        int profits = 0, hold = -prices[0], _hold, n = prices.length;

        for (int i = 1; i < n; i++) {
            _hold = hold;

            hold = Integer.max(hold, profits - prices[i]);
            profits = Integer.max(profits, _hold + prices[i] - fee);
        }

        return profits;
    }
}
