package org.coding;

import com.google.common.base.Strings;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DecodeString2 {

    public String solution(String s) {
        if(Strings.isNullOrEmpty(s)){
            return "";
        }

        Stack<String> words = new Stack<>();
        Queue<Integer> counts = new LinkedList<>();

        int index = 0;
        String result = "";
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int num = 0;
                while (Character.isDigit(s.charAt(index))) {
                    num = num * 10 + s.charAt(index) - '0';
                    index++;
                }
                counts.add(num);
            } else if (Character.isAlphabetic(c)) {
                result += c;
                index++;
            } else if (c == '[' || c == ']') {
                words.push(result);
                result = "";
                index++;
            } else if (c == '}') {
                int count = counts.poll();
                StringBuilder sb = new StringBuilder();
                String ss = words.pop();
                for (int k = 0; k < count; k++) {
                    sb.append(ss);
                }
                result = words.pop();
                result += sb.toString();
                index++;
            } else {
                index++;
            }
        }
        return result;
    }


    @Test
    public void test1() {
        String s = "ab[cd]{2}";
        Assert.assertEquals("abcdcd", solution(s));
    }

    @Test
    public void test4() {
        String s = "";
        Assert.assertEquals("", solution(s));
    }
    @Test
    public void test6() {
        String s = "abc";
        Assert.assertEquals("abc", solution(s));
    }

    @Test
    public void test5() {
        String s = null;
        Assert.assertEquals("", solution(s));
    }

    @Test
    public void test2() {
        String s = "def[ab[cd]{2}]{3}ghi";
        Assert.assertEquals("defabcdcdabcdcdabcdcdghi", solution(s));
    }

    @Test
    public void test3() {
        String s = "[ab[cd]{2}]{3}";
        Assert.assertEquals("abcdcdabcdcdabcdcd", solution(s));
    }

}
