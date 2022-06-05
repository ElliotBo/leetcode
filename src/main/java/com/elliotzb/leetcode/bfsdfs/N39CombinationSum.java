package com.elliotzb.leetcode.bfsdfs;

import java.util.ArrayList;
import java.util.List;

public class N39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();  //记录路径
        gen(res, path, candidates, 0, target);
        return res;
    }

    public void gen(List<List<Integer>> res, List<Integer> path, int[] candidates, int l, int target) {
        if (target < 0)
            return;

        if (target == 0)
            res.add(new ArrayList(path));

        for (int i = l; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                gen(res, path, candidates, i, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }
}
