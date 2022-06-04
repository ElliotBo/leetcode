package com.elliotzb.leetcode.bfsdfs;

public class N123BestTimeBuySellStock {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2) {
            return 0;
        }
        //一维是股价 二维是交易次数 0 1 2  三维是是否持有股票
        //定义买入的时候 交易次数+1
        int[][][] mp = new int[length][3][2];
        mp[0][1][1] = -prices[0];
        mp[0][2][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            mp[i][0][1] = Math.max(mp[i - 1][0][1], mp[i - 1][0][0] - prices[i]);
            mp[i][0][0] = mp[i - 1][0][0];
            mp[i][1][1] = Math.max(mp[i - 1][1][1], -prices[i]);
            mp[i][1][0] = Math.max(mp[i - 1][1][0], mp[i - 1][1][1] + prices[i]);
            mp[i][2][1] = Math.max(mp[i - 1][2][1], mp[i - 1][1][0] - prices[i]);
            mp[i][2][0] = Math.max(mp[i - 1][2][0], mp[i - 1][2][1] + prices[i]);
        }
        return Math.max(mp[length - 1][1][0], mp[length - 1][2][0]);
    }

}
