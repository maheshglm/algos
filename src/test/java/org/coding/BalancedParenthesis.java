package org.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParenthesis {

    private static boolean solution(String expression) {
        if (expression == null || expression.length() == 0) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> bucket = new Stack<>();
        for (Character c : expression.toCharArray()) {
            if (map.containsKey(c)) {
                bucket.push(c);
            } else if (map.get(bucket.peek()) == c) {
                bucket.pop();
            } else {
                return false;
            }
        }
        return bucket.empty();
    }

    @Test
    public void test1() {
        String expr = "()[]{}";
        Assert.assertTrue(solution(expr));
    }

    @Test
    public void test2() {
        String expr = "(()[]";
        Assert.assertFalse(solution(expr));
    }

    @Test
    public void test3() {
        String expr = "()[{}]{()}";
        Assert.assertTrue(solution(expr));
    }


}
