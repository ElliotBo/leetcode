package com.elliotzb.leetcode.bfsdfs;

public class N69Sqrtx {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int left = 1;
        int right = x / 2;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
                res = mid;
            }
        }
        return res;
    }


}
