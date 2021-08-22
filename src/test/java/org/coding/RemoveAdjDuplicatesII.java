package org.coding;

import org.junit.Test;

import java.util.Stack;

//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
public class RemoveAdjDuplicatesII {

    /*
    Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s
    and removing them causing the left and the right side of the deleted substring to concatenate together.
    We repeatedly make k duplicate removals on s until we no longer can.
    Return the final string after all such duplicate removals have been made.
    It is guaranteed that the answer is unique.
    */

    class Node {
        char ch;
        int times;

        public Node(char ch) {
            this.ch = ch;
            this.times = 1;
        }
    }

    private String solution1(String s, int k) {
        int n = s.length();
        if (n < k) return s;

        Stack<Node> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().ch != c) {
                stack.push(new Node(c));
            } else {
                if (stack.peek().times + 1 == k) {
                    stack.pop();
                } else {
                    stack.peek().times++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Node node : stack) {
            int times = node.times;
            char c = node.ch;
            for (int i = 0; i < times; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    @Test
    public void test1() {
        final String s = "abcd";
        final int k = 2;
        System.out.println(solution1(s, k)); //output = abcd, nothing to delete
    }

    @Test
    public void test2() {
        final String s = "deeedbbcccbdaa";
        final int k = 3;
        System.out.println(solution1(s, k)); //output = aa
    }

    @Test
    public void test3() {
        final String s = "pbbcggttciiippooaais";
        final int k = 2;
        System.out.println(solution1(s, k)); //output = ps
    }


}
