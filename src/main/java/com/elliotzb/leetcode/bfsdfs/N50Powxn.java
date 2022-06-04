package com.elliotzb.leetcode.bfsdfs;

public class N50Powxn {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0.0d;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0d;
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b = b >> 1;
        }
        return res;
    }

}
