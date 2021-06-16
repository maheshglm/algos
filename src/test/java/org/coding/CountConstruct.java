package org.coding;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {

    /*
   Function should return number of ways the 'target'
   can be constructed by concatenating elements of the 'wordBank' array
   Reuse elements is allowed.
   Hint: for empty target string answer is true as with no words we can make empty target
    */

    /*
    m = target.length
    n = wordBank.length
    Bruteforce - O(n^m*m) - Memo - O(m*n*m)
     */
    private int solution(String target, String[] wordBank, Map<String, Integer> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if ("".equals(target)) return 1;
        int result = 0;
        for (String s : wordBank) {
            if (target.startsWith(s)) {
                int ways = solution(target.substring(s.length()), wordBank, memo);
                result += ways;
            }
        }
        memo.put(target, result);
        return memo.get(target);
    }

    @Test
    public void test1() {
        String target = "abcdef";
        String[] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        System.out.println(solution(target, wordBank, new HashMap<>()));//1
    }

    @Test
    public void test2() {
        String target = "skateboard";
        String[] wordBank = {"bo", "rd", "ate", "ska", "sk", "boar"};
        System.out.println(solution(target, wordBank, new HashMap<>())); //0
    }

    @Test
    public void test3() {
        String target = "purple";
        String[] wordBank = {"purp", "p", "ur", "le", "purpl"};
        System.out.println(solution(target, wordBank, new HashMap<>())); //2
    }
}
