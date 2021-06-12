package org.coding;

import org.junit.Test;

import java.util.Stack;

//https://leetcode.com/problems/reformat-the-string/
public class ReformatString {

    /*
    Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
    You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.
    Return the reformatted string or return an empty string if it is impossible to reformat the string.
     */
    private String solution(String s) {

        Stack<Character> letters = new Stack<>();
        Stack<Integer> numbers = new Stack<>();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                numbers.add(c - '0');
            } else {
                letters.add(c);
            }
        }

        if (Math.abs(letters.size() - numbers.size()) > 2) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length() - 1; i++) {
            if (letters.size() >= numbers.size()) {
                if (!letters.isEmpty()) {
                    sb.append(letters.pop());
                }
                if (!numbers.isEmpty()) {
                    sb.append(numbers.pop());
                }
            }else {
                if (!numbers.isEmpty()) {
                    sb.append(numbers.pop());
                }
                if (!letters.isEmpty()) {
                    sb.append(letters.pop());
                }
            }
        }
        return sb.toString();
    }


    @Test
    public void test1() {
        String s = "a0b1c2";
        System.out.println(solution(s));//0a1b2c
        // Explanation: No two adjacent
        // characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b"
        // are also valid permutations.
    }

    @Test
    public void test2() {
        String s = "leetcode";
        System.out.println(solution(s)); //empty
    }

    @Test
    public void test3() {
        String s = "1229857369";
        System.out.println(solution(s)); //empty
    }

    @Test
    public void test4() {
        String s = "covid2019";
        System.out.println(solution(s)); //c2o0v1i9d
    }

    @Test
    public void test5() {
        String s = "ab123";
        System.out.println(solution(s)); //1a2b3
    }

    @Test
    public void test6() {
        String s = "j";
        System.out.println(solution(s)); //j
    }


}

