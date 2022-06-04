package com.elliotzb.leetcode.bfsdfs;

import java.util.Arrays;

public class N169MajorityElement {

    public int majorityElement(int[] nums) {
        int count = 0;
        int cand = 0;
        for (int num : nums) {
            if (count == 0) {
                cand = num;
            }
            count = count + ((num == cand) ? 1 : -1);
        }
        return cand;
    }

    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

}
