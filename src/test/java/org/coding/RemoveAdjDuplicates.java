package org.coding;

import org.junit.Test;

import java.util.Stack;

public class RemoveAdjDuplicates {

    private String solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    @Test
    public void test1() {
        String s = "abbaca";
        System.out.println(solution(s));//ca
    }
}
