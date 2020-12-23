package org.facebook.Trees;

//https://www.youtube.com/watch?v=LU4fGD-fgJQ
//https://www.youtube.com/watch?v=Nl8Q1o8u88E
//https://leetcode.com/problems/balanced-binary-tree/
//https://www.youtube.com/watch?v=zu22twD5QI4
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) < 2 &&
                isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode node) {
        if (node == null) return -1;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

}
