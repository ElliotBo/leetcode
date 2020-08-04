package com.elliotzb.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * 72
 * DP[i][j]代表 第一个字符串的i个字符 变至 第二个字符串的j个字符 的最少操作次数
 * 因此dp[i][j]=less(dp[i]dp[j-1],dp[i-1]dp[j],dp[i-1]dp[j-1])+1
 * 分别对应增加 删除 替换
 */
public class N72MinDistance {
    public int minDistance(String word1, String word2) {
        int oneLength = word1.length();
        int twoLength = word2.length();
        int[][] source = new int[oneLength+1][twoLength+1];
        for (int i = 1; i < oneLength+1; i++) {
            source[i][0]=i;
        }
        for (int i = 1; i < twoLength+1; i++) {
            source[0][i]=i;
        }
        for (int i = 1; i < oneLength+1; i++) {
            for (int j = 1; j < twoLength+1; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    source[i][j] = source[i-1][j-1];
                    continue;
                }
                source[i][j]=Math.min(Math.min(source[i][j-1],source[i-1][j]),source[i-1][j-1])+1;
            }
        }
        return source[oneLength][twoLength];
    }

    public static void main(String[] args)
    {
        System.out.println(new N72MinDistance().minDistance("as3f11","1234"));
    }
}
