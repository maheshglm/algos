package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {


    public List solution1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return Collections.EMPTY_LIST;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            StringBuilder sb = new StringBuilder();

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            for (int c : count) {
                sb.append(c);
            }

            String t = sb.toString();

            if (!map.containsKey(t)) {
                map.put(t, new ArrayList<>());
            }

            map.get(t).add(s);

        }
        return new ArrayList<>(map.values());

    }

    //O(n*klogk) - n is lenth of strs array, k is length of each string in array
    public List<List<String>> solution(String[] strs) {

        if (strs == null || strs.length == 0) {
            return Collections.EMPTY_LIST;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String t = sort(s);
            if (!map.containsKey(t)) {
                map.put(t, new ArrayList<>());
            }
            map.get(t).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String sort(String s) {
        char[] arrs = s.toCharArray();
        Arrays.sort(arrs);
        return new String(arrs);
    }

    @Test
    public void test1() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        //Output = [["bat"],["nat","tan"],["ate","eat","tea"]]
        System.out.println(solution(strs));
        System.out.println(solution1(strs));
    }

    @Test
    public void test2() {
        String[] strs = {""};
        //Output = [[""]]
        System.out.println(solution(strs));

    }

    @Test
    public void test3() {
        String[] strs = {"a"};
        //Output = [["a"]]
        System.out.println(solution(strs));

    }
}
