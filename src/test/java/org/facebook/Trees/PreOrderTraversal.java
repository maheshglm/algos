package org.facebook.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.youtube.com/watch?v=vMHaqhiTn7Y
public class PreOrderTraversal {

    private List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }
        return result;
    }

    private List<Integer> solution1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr != null) {
                result.add(curr.val);
                stack.push(curr.right);
                stack.push(curr.left);
            }
        }
        return result;
    }

    private List<Integer> solution2(TreeNode root) {
        return dfs(root, new ArrayList<>());
    }

    private List<Integer> dfs(TreeNode root, List<Integer> list){
        if(root == null) return list;
        list.add(root.val);
        list = dfs(root.left, list);
        return dfs(root.right, list);
    }
}
