package com.elliotzb.leetcode.dp;

public class N152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[2][2];
        int result = dp[0][0] = dp[0][1] = nums[0];
        int index;
        int before;
        for (int i = 1; i < nums.length; i++) {
            index = i % 2;
            before = (i - 1) % 2;
            dp[index][0] = Math.max(Math.max(dp[before][0] * nums[i], dp[before][1] * nums[i]), nums[i]);
            dp[index][1] = Math.min(Math.min(dp[before][0] * nums[i], dp[before][1] * nums[i]), nums[i]);
            result = Math.max(dp[index][0], result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] xx = new int[] {2, 3, -2, 4};
        System.out.println(new N152MaximumProductSubarray().maxProduct(xx));
    }
}