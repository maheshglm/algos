package org.facebook.Trees;

//https://www.youtube.com/watch?v=RIDBLO-S7OA
public class InsertBinarySearchTree {

    //iteratively
    public TreeNode solution(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        TreeNode curr = root;
        while (true) {
            if (value < curr.val) {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(value);
                    break;
                }
            } else {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(value);
                }
            }
        }
        return root;
    }

    //recursively
    public TreeNode solution1(TreeNode root, int value) {
        return recursive(root, value);
    }

    private TreeNode recursive(TreeNode curr, int val) {
        if (curr == null) {
            return new TreeNode(val);
        }

        if (val < curr.val) {
            curr.left = recursive(curr.left, val);
        } else {
            curr.right = recursive(curr.right, val);
        }
        return curr;
    }


}
