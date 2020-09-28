package com.elliotzb.leetcode.bfsdfs;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 */
public class N104MaximumDepthOfBinaryTree {
    // public int maxDepth(TreeNode root) {
    //
    //     if (null == root) {
    //         return 0;
    //     }
    //
    //     int maxDepth = 0;
    //
    //     Queue<TreeNode> curLevel = new LinkedList<>();
    //     curLevel.add(root);
    //
    //     while (null != curLevel.peek()) {
    //         maxDepth++;
    //         int currSize = curLevel.size();
    //         for (int i = 0; i < currSize; i++) {
    //             TreeNode node = curLevel.poll();
    //             if (null != node.left) {
    //                 curLevel.add(node.left);
    //             }
    //             if (null != node.right) {
    //                 curLevel.add(node.right);
    //             }
    //         }
    //     }
    //     return maxDepth;
    // }

    public int maxDepth(TreeNode root) {
        return null == root ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
        System.out.println(new N104MaximumDepthOfBinaryTree().maxDepth(ff10));
    }

}
