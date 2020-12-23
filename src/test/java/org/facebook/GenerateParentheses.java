package org.facebook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=sz1qaKt0KGQ - good explanation
//https://www.youtube.com/watch?v=qBbZ3tS0McI&t=398s
public class GenerateParentheses {

    private List<String> solution(int n) {
        List<String> output = new ArrayList<>();
        generate(output, "", 0, 0, n);
        return output;
    }

    private void generate(List<String> output, String curr_string, int open, int close, int max) {
        if (curr_string.length() == max * 2) {
            output.add(curr_string);
            return;
        }

        if (open < max) {
            generate(output, curr_string + "(", open + 1, close, max);
        }

        if (close < open) {
            generate(output, curr_string + ")", open, close + 1, max);
        }
    }

    @Test
    public void test1() {
        int n = 3;
        System.out.println(solution(n));
        //Output: ["((()))","(()())","(())()","()(())","()()()"]
    }

    @Test
    public void test2() {
        int n = 1;
        //Output: ["()"]
        System.out.println(solution(n));

    }

    @Test
    public void test3() {
        int n = 2;
        //Output: ["()()", "(())"]
        System.out.println(solution(n));

    }

}
