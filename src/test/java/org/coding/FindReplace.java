package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/find-and-replace-in-string/
public class FindReplace {


    private String solution(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); ) {
            if (map.containsKey(s.charAt(i))) {

            } else {
                sb.append(s.charAt(i));
            }
        }

        return "";

    }

    @Test
    public void test1() {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"a", "cd"};
        String[] targets = {"eee", "ffff"};

        System.out.println(solution(s, indices, sources, targets));
        /*
        Output: "eeebffff"
        Explanation:
        "a" occurs at index 0 in s, so we replace it with "eee".
        "cd" occurs at index 2 in s, so we replace it with "ffff".
         */
    }

    @Test
    public void test2() {
        String s = "abcd";
        int[] indices = {0, 2};
        String[] sources = {"ab", "ec"};
        String[] targets = {"eee", "ffff"};
        /*
        Output: "eeecd"
        Explanation:
        "ab" occurs at index 0 in s, so we replace it with "eee".
        "ec" does not occur at index 2 in s, so we do nothing.
         */
    }


}
