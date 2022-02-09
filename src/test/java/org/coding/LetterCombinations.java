package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//https://www.youtube.com/watch?v=nNGSZdx6F3M
public class LetterCombinations {

    static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private List<String> solution(String digits) {
        List<String> result = new ArrayList<>();

        //check input
        if (digits != null && digits.length() > 0) {
            dfs(digits, result, new StringBuilder(), 0);
        }
        return result;
    }

    private void dfs(String digits, List<String> result, StringBuilder sb, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int num = digits.charAt(index) - '0';

        for (char c : map[num].toCharArray()) {
            sb.append(c);
            dfs(digits, result, sb, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    @Test
    public void test1() {
        String s = "23";
        System.out.println(solution(s));
        //[ad, ae, af, bd, be, bf, cd, ce, cf]
    }

    @Test
    public void test2() {
        String s = "235";
        System.out.println(solution(s));
        //[adj, adk, adl, aej, aek, ael, afj, afk, afl, bdj, bdk, bdl, bej, bek, bel, bfj, bfk, bfl, cdj, cdk, cdl, cej, cek, cel, cfj, cfk, cfl]
    }


}
