package org.facebook.Trees;

public class MaximumDepthBinaryTree {
    /*This is bottom up approach */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    /*top down approach*/

    private int answer;

    public int maxDepth1(TreeNode root) {
        int depth = 1;
        recursive(root, depth);
        return answer;
    }

    private void recursive(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            answer = Math.max(depth, answer);
        }

        recursive(node.left, depth + 1);
        recursive(node.right, depth + 1);
    }
}
