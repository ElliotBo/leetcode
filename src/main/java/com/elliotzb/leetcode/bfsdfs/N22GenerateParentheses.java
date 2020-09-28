package com.elliotzb.leetcode.bfsdfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/submissions/
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *  
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 */
public class N22GenerateParentheses {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        if (0 == n) {
            return res;
        }
        handle(res, n, n, "");
        return res;
    }

    private void handle(List<String> res, int left, int right, String cur) {
        if (left == 0 && right == 0) {
            res.add(cur);
            return;
        }
        if (left > 0) {
            handle(res, left-1, right, cur + "(");
        }
        if (right > left) {
            handle(res, left, right-1, cur + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(new N22GenerateParentheses().generateParenthesis(3));
    }
}
