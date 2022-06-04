package com.elliotzb.leetcode.bfsdfs;

public class N121BestTimeBuySellStock {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 1){
            return 0;
        }

        int[][] mp = new int[length][2];
        mp[0][0] = 0;
        mp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            mp[i][0] = Math.max(mp[i-1][0], mp[i-1][1]+prices[i]);
            mp[i][1] = Math.max(mp[i-1][1], -prices[i]);
        }
        return mp[length-1][0];
    }

}
