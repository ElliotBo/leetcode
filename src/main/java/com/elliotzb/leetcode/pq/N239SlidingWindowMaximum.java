package com.elliotzb.leetcode.pq;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || nums.length == 0 || k == 0) {
            return new int[0];
        }

        //用于存储在窗口中nums下标，否则无法判断需要删除的大小
        ArrayDeque<Integer> window = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i >= k && window.peek() <= i - k) {
                window.poll();
            }

            while (window.size() > 0 && nums[window.peekLast()] <= nums[i]) {
                window.pollLast();
            }

            window.add(i);

            if (i >= k - 1) {
                res.add(nums[window.peek()]);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        N239SlidingWindowMaximum hehe = new N239SlidingWindowMaximum();
        Arrays.stream(hehe.maxSlidingWindow(new int[] {1, 3, 1, 2, 0, 5}, 3)).forEach(System.out::println);
        System.out.println("-------");
        Arrays.stream(hehe.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3)).forEach(System.out::println);
        System.out.println("-------");
        Arrays.stream(hehe.maxSlidingWindow(new int[] {1, -1}, 1)).forEach(System.out::println);
    }
}
