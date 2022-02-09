package org.coding;

import com.google.common.base.Strings;
import org.junit.Test;

import java.util.Stack;

//https://leetcode.com/discuss/interview-question/1061028/Indeed-or-Phone-Screen-(Karat)-or-Parent-Child-Graph-and-Calculator
public class Karat5 {

    /*
    This solution works even for Karat4 type of problem as well
    same as Karat4 but with nested expression.
    e.g. "12 + 2 + ((4 - 19) - 1)" containing ( and ) brackets only.
    Evaluate and return the answer to this expression.
    Input: "12 - (1 - 2)" Output: 13
     */

    private int solution(String expression) {
        int result = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();
        int i = 0;

        while (i < expression.length()) {
            char c = expression.charAt(i);
            if (Character.isDigit(c)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                result += sign * num;
                i--;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                int lastSign = stack.pop();
                int lastResult = stack.pop();
                result = result * lastSign + lastResult;
            }
            i++;
        }
        return result;
    }


    @Test
    public void test1() {
        String e = "(1+(4+5+2)-3)+(6+8)";
        //System.out.println(solution(e)); //23
        System.out.println(solution(e));
    }

    @Test
    public void test2() {
        String e = "12 - (1 - 2)";
        //System.out.println(solution(e)); //13
        System.out.println(solution(e));
    }

}
