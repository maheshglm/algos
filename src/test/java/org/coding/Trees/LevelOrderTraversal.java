package org.coding.Trees;

import java.util.*;

//https://www.youtube.com/watch?v=sFDNL6r5aDM
//https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrderTraversal {

    private List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                level.add(curr.val);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            result.add(level);
        }

        Collections.reverse(result);
        return result;
    }


}
