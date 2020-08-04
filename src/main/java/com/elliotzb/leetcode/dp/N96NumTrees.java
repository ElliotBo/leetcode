package com.elliotzb.leetcode.dp;

/**
 * 96
 */
public class N96NumTrees {
    public int numTrees(int n) {
        if (n < 2)
        {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i]= dp[i]+dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args)
    {
        System.out.println(new N96NumTrees().numTrees(2));
    }
}
