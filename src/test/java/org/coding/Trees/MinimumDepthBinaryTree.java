package org.coding.Trees;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=BVrrrscTFKk
public class MinimumDepthBinaryTree {


    /*we ll use level order traversal to find minDepth*/


    public int solution(TreeNode root) {
        if (root == null) return 0;

        int minDepth = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr_node = q.poll();
                if (curr_node.left == null && curr_node.right == null) return minDepth;

                if (curr_node.left != null) q.add(curr_node.left);
                if (curr_node.right != null) q.add(curr_node.right);
            }
            minDepth++;
        }

        return 0;
    }

    /*Recursive approach*/
    public int solution1(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        if (root.left == null) {
            return solution1(root.right) + 1;
        }
        if (root.right == null) {
            return solution1(root.left) + 1;
        }
        return Math.min(solution1(root.left), solution1(root.right)) + 1;
    }

}
