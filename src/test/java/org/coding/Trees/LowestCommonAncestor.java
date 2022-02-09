package org.coding.Trees;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

public class LowestCommonAncestor {

    private TreeNode solution1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = solution1(root.left, p, q);
        TreeNode right = solution1(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;
        return root;
    }


}
