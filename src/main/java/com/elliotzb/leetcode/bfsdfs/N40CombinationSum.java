package com.elliotzb.leetcode.bfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N40CombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();  //记录路径
        gen(res, path, candidates, 0, target);
        return res;
    }

    public void gen(List<List<Integer>> res, List<Integer> path, int[] candidates, int l, int target) {
        if (target < 0) return;

        if (target == 0) res.add(new ArrayList<>(path));

        for (int i = l; i < candidates.length; i++) {
            if (i > l && candidates[i] == candidates[i - 1]) continue;
            if (candidates[i] <= target) {
                path.add(candidates[i]);
                gen(res, path, candidates, i + 1, target - candidates[i]);
                path.remove(path.size() - 1);
            }
        }
    }
}
