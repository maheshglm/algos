package org.coding.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.youtube.com/watch?v=QxFOR8sQuB4
//https://www.youtube.com/watch?v=WZwNoTm_9d8
public class InorderTraversal {

    private List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }


    //recursively
    private List<Integer> solution1(TreeNode root) {
        return dfs(root, new ArrayList<>());
    }

    private List<Integer> dfs(TreeNode root, List<Integer> list) {
        if (root == null) return list;

        list = dfs(root.left, list);
        list.add(root.val);
        list = dfs(root.right, list);
        return list;
    }
}
