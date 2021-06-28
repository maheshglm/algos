package org.coding;

import com.google.common.base.Strings;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://github.com/IDeserve/learn/blob/master/PalindromePartitionMinCut.java - dp with table
//https://www.youtube.com/watch?v=WPr1jDh3bUQ
//https://leetcode.com/problems/palindrome-partitioning-ii/
public class PalindromePartitioningII {

    //https://www.youtube.com/watch?v=9h10fqkI7Nk
    //dp using tablization
    private int solution1(String s) {
        if (s == null || s.length() == 0) return 0;
        //return recursive(s, 0, s.length() - 1);
        return memo(s, 0, s.length() - 1, new Integer[s.length() + 1][s.length() + 1]);
    }

    private int recursive(String s, int i, int j) {
        if (i >= j || isPalindrome(s, i, j)) return 0;

        int min = Integer.MAX_VALUE;
        int temp;
        for (int k = i; k < j; k++) {
            temp = recursive(s, i, k) + recursive(s, k + 1, j) + 1;
            min = Math.min(min, temp);
        }
        return min;
    }

    //https://www.youtube.com/watch?v=9h10fqkI7Nk
    //with dp but memoization
    private int memo(String s, int i, int j, Integer[][] memoArray) {
        if (i >= j || isPalindrome(s, i, j)) return 0;

        if (memoArray[i][j] != null) return memoArray[i][j];

        int min = Integer.MAX_VALUE;
        int temp;


        for (int k = i; k < j; k++) {
            int left = 0;
            int right = 0;

            if (memoArray[i][k] != null) {
                left = memoArray[i][k];
            } else {
                left = memo(s, i, k, memoArray);
            }

            if (memoArray[k + 1][j] != null) {
                right = memoArray[k + 1][j];
            } else {
                right = memo(s, k + 1, j, memoArray);
            }

            temp = left + right + 1;
            min = Math.min(min, temp);
        }
        memoArray[i][j] = min;
        return min;
    }


    public int solution(String s) {
        if (Strings.isNullOrEmpty(s) || s.length() == 0) return 0;
        int[] minCuts = new int[]{Integer.MAX_VALUE};
        dfs(s, minCuts, new ArrayList<>(), 0);
        return minCuts[0] - 1;
    }

    private void dfs(String s, int[] minCuts, List<String> temp, int index) {
        if (index >= s.length()) {
            minCuts[0] = Math.min(minCuts[0], temp.size());
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                temp.add(s.substring(index, i + 1));
                dfs(s, minCuts, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test1() {
        String s = "Banana";
        //System.out.println(solution(s));
        System.out.println(solution1(s));//1
    }

    @Test
    public void test2() {
        String s = "aab";
        //System.out.println(solution(s));
        System.out.println(solution1(s));//1
    }

    @Test
    public void test3() {
        String s = "abccd";
        System.out.println(solution(s));
        System.out.println(solution1(s));
    }

    //Time limit exceeded
    @Test
    public void test4() {
        String s = "ababababababababababababcbabababababababababababa";
        System.out.println(solution1(s));
    }

    @Test
    public void test5() {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(solution1(s));
    }

    @Test
    public void test6() {
        String s = "leet";
        System.out.println(solution(s));
        System.out.println(solution1(s));
    }
}
