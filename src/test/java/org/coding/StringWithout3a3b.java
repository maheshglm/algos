package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/string-without-aaa-or-bbb/

/*
    Given two integers a and b, return any string s such that:
    s has length a + b and contains exactly a 'a' letters, and exactly b 'b' letters,
    The substring 'aaa' does not occur in s, and
    The substring 'bbb' does not occur in s.
 */

public class StringWithout3a3b {

    private String solution1(int a, int b) {
        StringBuilder sb = new StringBuilder();

        int k = a == b ? 2 : 1;

        char first = a > b ? 'a' : 'b';
        char last = a > b ? 'b' : 'a';

        int first_num = Math.max(a, b);
        int last_num = Math.min(a, b);

        int counter = 0;
        while (first_num > 0 || last_num > 0) {

            while (true) {
                if (first_num > 0) {
                    sb.append(first);
                    counter++;
                    first_num--;
                    if (counter % k == 0) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (last_num > 0) {
                sb.append(last);
            }
            last_num--;
        }
        return sb.toString();
    }

    private String solution(int a, int b) {

        StringBuilder sb = new StringBuilder();
        char x = 'a';
        char y = 'b';

        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;

            char ch = x;
            x = y;
            y = ch;
        }

        while (a > 0 || b > 0) {
            if (a > b) {
                sb.append(x);
                a--;
            }
            if (a > 0) {
                sb.append(x);
                a--;
            }
            if (b > 0) {
                sb.append(y);
                b--;
            }
        }
        return sb.toString();

    }

    @Test
    public void test1() {
        int a = 1;
        int b = 2;
        System.out.println(solution(a, b)); //abb, bab, bba etc
        System.out.println(solution1(a, b)); //abb, bab, bba etc
    }

    @Test
    public void test2() {
        int a = 4;
        int b = 1;
        System.out.println(solution(a, b)); //aabaa
        System.out.println(solution1(a, b)); //aabaa
    }

    @Test
    public void test3() {
        int a = 1;
        int b = 3;
        System.out.println(solution(a, b));
        System.out.println(solution1(a, b));
    }

    @Test
    public void test4() {
        int a = 4;
        int b = 4;
        System.out.println(solution(a, b));
        System.out.println(solution1(a, b));
    }


}
