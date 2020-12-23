package org.facebook;

import org.junit.Test;

//https://www.youtube.com/watch?v=BVjKq4SH364&list=RDCMUCPZ473Q4kbG98JmL71PgXTA&index=7
public class RoboReturnToOrigin {

    private boolean solution(String s) {
        char[] chars = s.toCharArray();
        int horizontal = 0;
        int vertical = 0;

        for (char c : chars) {
            switch (c) {
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
                case 'L':
                    horizontal--;
                    break;
                case 'R':
                    horizontal++;
                    break;
            }
        }
        return horizontal == 0 && vertical == 0;
    }

    @Test
    public void test1() {
        String s = "UD"; //true
        System.out.println(solution(s));
    }

    @Test
    public void test2() {
        String s = "LL"; //false
        System.out.println(solution(s));

    }

}
