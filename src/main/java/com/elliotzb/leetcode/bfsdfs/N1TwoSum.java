package com.elliotzb.leetcode.bfsdfs;

import java.util.HashMap;
import java.util.Map;

public class N1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                res[0] = map.get(tmp);
                res[1] = i;
                return res;
            } else {
                map.put(nums[i], i);
            }

        }
        return res;
    }
}
