package com.elliotzb.leetcode.bfsdfs;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/submissions/
 *
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 */
public class N111MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
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
        System.out.println(new N111MinimumDepthOfBinaryTree().minDepth(ff10));
    }
}
