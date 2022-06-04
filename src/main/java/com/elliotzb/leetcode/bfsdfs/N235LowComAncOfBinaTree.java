package com.elliotzb.leetcode.bfsdfs;

public class N235LowComAncOfBinaTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)  return null;

        if (p.val < root.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

}
