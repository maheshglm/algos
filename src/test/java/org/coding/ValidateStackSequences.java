package org.coding;

import org.junit.Test;

import java.util.Stack;

//https://leetcode.com/problems/validate-stack-sequences/
public class ValidateStackSequences {

    //Given two sequences pushed and popped with distinct values,
    //return true if and only if this could have been the result of a sequence of
    //push and pop operations on an initially empty stack.

    private boolean solution(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushed.length && j < popped.length) {
            stack.add(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
            i++;
        }
        return stack.isEmpty();
    }

    @Test
    public void test1() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(solution(pushed, popped));//true
    }

    @Test
    public void test2() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        System.out.println(solution(pushed, popped));//false
    }
}
