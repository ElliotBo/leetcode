package com.elliotzb.leetcode.dp;

import java.util.List;

public class N120Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size();
        int[] dp = new int[level + 1];
        for (int i = level - 1; i >= 0; i--) {
            for (int j = 0; j < i + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}