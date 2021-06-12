package org.coding;

import org.junit.Test;

import static java.lang.String.valueOf;

public class Problem1 {


    public int solution(String S) {
        if (S.length() == 2) {
            return Integer.parseInt(S);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < S.length() - 1; i++) {
            int num = Integer.parseInt(S.charAt(i) + valueOf(S.charAt(i + 1)));
            if (num > result) {
                result = num;
            }
        }

        return result;

    }

    @Test
    public void test() {
        String s = "88";
        int solution = solution(s);
        System.out.println(solution);

    }
}
