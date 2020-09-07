package com.elliotzb.leetcode.dp;

public class N1139LargestBorderedSquare {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int[][][] dp = new int[n + 1][m + 1][2];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    dp[i][j][0] = dp[i - 1][j][0] + 1;
                    dp[i][j][1] = dp[i][j - 1][1] + 1;
                }
            }
        }
        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int target = Math.min(dp[i][j][0], dp[i][j][1]);
                if (target == 0) {
                    continue;
                }
                if ((j == 1 || i == 1) && dp[i][j][0] >= 1 && dp[i][j][1] >= 1) {
                    res = Math.max(res, 1);
                    continue;
                }
                for (int k = target; k > 0; k--) {
                    if (dp[i][j - k + 1][0] >= k && dp[i - k + 1][j][1] >= k) {
                        res = Math.max(k, res);
                        break;
                    }
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] grid1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        int[][] grid2 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        System.out.println(new N1139LargestBorderedSquare().largest1BorderedSquare(grid));
        System.out.println(new N1139LargestBorderedSquare().largest1BorderedSquare(grid1));
        System.out.println(new N1139LargestBorderedSquare().largest1BorderedSquare(grid2));
    }
}
