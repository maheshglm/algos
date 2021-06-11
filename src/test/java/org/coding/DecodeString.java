package org.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

//https://www.youtube.com/watch?v=CW3ZYAN5Huo
//https://www.youtube.com/watch?v=0iQqj5egK9k&list=PLJzWER-4CS8h0LTNS_xliZFqdcnp_2uW-&index=81&t=369s
public class DecodeString {

    private String solution(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int num = 0;
                while (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + Character.getNumericValue(s.charAt(i));
                    i++;
                }
                counts.push(num);
            } else if (ch == '[') {
                result.push(res);
                res = "";
                i++;
            } else if (ch == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int count = counts.pop();
                for (int j = 0; j < count; j++) {
                    temp.append(res);
                }
                res = temp.toString();
                i++;
            } else {
                res += ch;
                i++;
            }
        }
        return res;
    }

    @Test
    public void test1() {
        String s = "3[a]2[bc]";
        System.out.println(solution(s)); //aaabcbc
    }

    @Test
    public void test2() {
        String s = "3[a2[c]]";
        System.out.println(solution(s)); //accaccacc
    }

    @Test
    public void test3() {
        String s = "2[abc]3[cd]ef";
        System.out.println(solution(s)); //abcabccdcdcdef
    }

    @Test
    public void test4() {
        String s = "100[leetcode]";
        String expected = "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode";
        Assert.assertEquals(expected, solution(s));
    }

}
