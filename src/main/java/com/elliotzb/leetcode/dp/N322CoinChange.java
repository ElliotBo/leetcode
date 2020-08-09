package com.elliotzb.leetcode.dp;

public class N322CoinChange
{
    public int coinChange(int[] coins, int amount) {
        if (amount==0)
            return 0;
        if (amount<0)
            return -1;
        int[] dp = new int[amount+1];
        for (int i = 1; i < amount+1; i++)
        {
            dp[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i++)
        {
            for (int j = 0; j < coins.length; j++)
            {
                if (coins[j]<=i)
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }
        return dp[amount] > amount ? -1:dp[amount];
    }

    public static void main(String []args)
    {
        System.out.println(new N322CoinChange().coinChange(new int[]{2},3));
    }
}
