package com.elliotzb.leetcode.dp;

public class N70ClimbingStairs
{
    public int climbStairs(int n) {
        if (n<=2)
            return n;

        int[] dp = new int[2];
        dp[0]=1;
        dp[1]=2;
        for (int i = 2; i < n; i++)
        {
            if (i%2==0)
                dp[0]=dp[1]+dp[0];
            if (i%2==1)
                dp[1]=dp[1]+dp[0];
        }

        return Math.max(dp[0],dp[1]);
    }

    public static void main(String []args)
    {
        System.out.println(new N70ClimbingStairs().climbStairs(3));
    }
}
