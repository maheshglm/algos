package org.coding;

import com.google.common.base.Strings;
import org.junit.Test;

//https://leetcode.com/discuss/interview-question/1061028/Indeed-or-Phone-Screen-(Karat)-or-Parent-Child-Graph-and-Calculator
public class Karat4 {

    /*
    Question 1)
    Write a method which accepts a simple string mathematical expression,
    e.g. "1 - 3 + 2", which only contains + and - operators and valid integers,
    and returns the integer evaluation of the expression.
    Input: "12 - 19 + 2" Output: -5
    Input: "121" Output: 121
     */

    private int solution(String expression) {
        if (Strings.isNullOrEmpty(expression)) return 0;

        int result = 0;
        int sign = 1;

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
            }
            i++;
        }
        return result;
    }


    @Test
    public void test1() {
        String e = "12 - 19 + 2";
        //System.out.println(solution(e)); //-5
        System.out.println(solution(e));
    }

    @Test
    public void test2() {
        String e = "123 + 12 - 19 - 2 - 1 + 0";
        //System.out.println(solution(e)); //113
        System.out.println(solution(e));
    }

    @Test
    public void test3() {
        String e = "123";
        //System.out.println(solution(e)); //123
        System.out.println(solution(e));
    }

    @Test
    public void test4() {
        String e = "1 - 3 + 2";
        //System.out.println(solution(e)); //0
        System.out.println(solution(e));
    }

    @Test
    public void test5() {
        String e = " 2-1 + 2 ";
        //System.out.println(solution(e)); //3
        System.out.println(solution(e));
    }

    @Test
    public void test6() {
        String e = "1 + 1";
        //System.out.println(solution(e)); //2
        System.out.println(solution(e));
    }


}
