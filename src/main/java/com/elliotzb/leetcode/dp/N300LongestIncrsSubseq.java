package com.elliotzb.leetcode.dp;

public class N300LongestIncrsSubseq {
    public int lengthOfLIS(int[] nums) {
        if (nums.length<=1)
            return nums.length;
        int length = nums.length;
        int [] dp = new int[length];
        int result=0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]);
                }
            }
            dp[i]=dp[i]+1;
            result = Math.max(dp[i],result);
        }
        return result;
    }

    public static void main(String [] args)
    {
        System.out.println(new N300LongestIncrsSubseq().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
