package org.coding.Trees;

public class SearchBinarySearchTree {


    //Recursive
    private TreeNode solution1(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        if (val < root.val) {
            return solution1(root.left, val);
        }
        return solution1(root.right, val);
    }

    //Iterative
    private TreeNode solution2(TreeNode root, int val) {
        if (root == null) return null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.val == val) return curr;
            if (val < root.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return null;
    }


}
