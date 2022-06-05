package com.elliotzb.leetcode.bfsdfs;

import java.util.*;

public class N103BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> asd = new ArrayList<>();
        if (null == root) return asd;

        Queue<TreeNode> currLevel = new LinkedList<>();
        currLevel.add(root);
        boolean isZheng = true;
        while (currLevel.peek() != null) {
            int num = currLevel.size();
            Deque<Integer> result = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                TreeNode node = currLevel.poll();
                if (isZheng) {
                    result.offerLast(node.val);
                } else {
                    result.offerFirst(node.val);
                }
                if (null != node.left) {
                    currLevel.add(node.left);
                }
                if (null != node.right) {
                    currLevel.add(node.right);
                }
            }
            asd.add(new LinkedList<>(result));
            isZheng = !isZheng;
        }
        return asd;
    }

    public List<List<Integer>> zigzagLevelOrderDfs(TreeNode root) {
        List<List<Integer>> asd = new ArrayList<>();
        if (null == root) return asd;
        gen(asd, root, 0, true);
        return asd;
    }

    public void gen(List<List<Integer>> res, TreeNode node, int level, boolean isZheng) {
        if (null == node) {
            return;
        }
        if (level >= res.size()) {
            res.add(new LinkedList());
        }
        List<Integer> list = res.get(level);

        if (isZheng) {
            list.add(node.val);
        } else {
            list.add(0, node.val);
        }
        //处理左子树
        gen(res, node.left, level + 1, !isZheng);
        //处理右子树
        gen(res, node.right, level + 1, !isZheng);
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
        List<List<Integer>> res = new N103BinaryTreeLevelOrderTraversal().zigzagLevelOrderDfs(ff10);
//        List<List<Integer>> resbfs = new N102BinaryTreeLevelOrderTraversal().levelOrder(ff10);
        System.out.println(res);
//        System.out.println(resbfs);
        int i=1;
        int l=4;
        int k = (i+l)/2;
        System.out.println((i+l)/2);
        System.out.println(k);
        String as="b";
        System.out.println(as.charAt(0)-'a');
        int[] aa = new int[2];
        aa[0]=4;
        aa[1]=4;
        aa[1]--;
        System.out.println(aa[1]);
    }

}
