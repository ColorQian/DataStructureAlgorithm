package com.programmercarl.dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BuySellStock3 {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;

        /**
         * 确定dp[i][j]数组以及下标的含义 (i表示第几天，j表示当天的状态)
         * 一天一共就有五个状态 j :
         * 0:没有操作
         * 1:第一次买入
         * 2:第一次卖出
         * 3:第二次买入
         * 4:第二次卖出
         */
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }
}
