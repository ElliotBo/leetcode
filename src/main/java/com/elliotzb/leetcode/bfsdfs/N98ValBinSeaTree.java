package com.elliotzb.leetcode.bfsdfs;

public class N98ValBinSeaTree {
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (null == root) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        if (pre >= root.val) {
            return false;
        }

        pre = root.val;

        return isValidBST(root.right);
    }

    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if (null != min && root.val <= min) return false;
        if (null != max && root.val >= max) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
