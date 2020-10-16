package com.elliotzb.leetcode.bfsdfs;

public class ThreeOrder {

    public void preOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void midOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        midOrder(root.left);
        System.out.print(root.val + " ");
        midOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
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
        new ThreeOrder().preOrder(ff10);
        System.out.println();
        System.out.println("-----------------");
        new ThreeOrder().midOrder(ff10);
        System.out.println();
        System.out.println("-----------------");
        new ThreeOrder().postOrder(ff10);
    }
}
