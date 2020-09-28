package com.elliotzb.leetcode.bfsdfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 */

public class N102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        Queue<TreeNode> currLevel = new LinkedList<>();
        currLevel.add(root);

        while (currLevel.peek() != null) {
            int size = currLevel.size();
            List<Integer> current = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = currLevel.poll();
                current.add(node.val);
                if (null != node.left) {
                    currLevel.add(node.left);
                }
                if (null != node.right) {
                    currLevel.add(node.right);
                }
            }
            res.add(current);
        }
        return res;
    }

    public List<List<Integer>> levelOrderDFS(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        generate(res, root, 0);
        return res;
    }

    private void generate(List<List<Integer>> res, TreeNode root, int level) {
        if (null == root) {
            return;
        }
        if (res.size() < level + 1) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);

        if (null != root.left) {
            generate(res, root.left, level + 1);
        }
        if (null != root.right) {
            generate(res, root.right, level + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode ff7 = new TreeNode(7);
        TreeNode ff8 = new TreeNode(8);
        TreeNode ff9 = new TreeNode(9);
        TreeNode ff10 = new TreeNode(10);
        TreeNode ff11 = new TreeNode(11);
        TreeNode ff12 = new TreeNode(12);
        TreeNode ff13 = new TreeNode(13);

        ff10.left = ff8;
        ff10.right = ff12;
        ff8.left = ff7;
        ff8.right = ff9;
        ff12.left = ff11;
        ff12.right = ff13;
        List<List<Integer>> res = new N102BinaryTreeLevelOrderTraversal().levelOrderDFS(ff10);
        List<List<Integer>> resbfs = new N102BinaryTreeLevelOrderTraversal().levelOrder(ff10);
        System.out.println(res);
        System.out.println(resbfs);
    }
}