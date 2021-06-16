package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=oBt53YbR9Kk&t=2328s
public class CanConstruct {

    /*
    Function should return a boolean indicating whether or not the 'target'
    can be constructed by concatenating elements of the 'wordBank' array
    Reuse elements is allowed.
    Hint: for empty target string answer is true as with no words we can make empty target
     */

    /*
    It is slow for longer strings

    m = target.length
    n = wordBank.length
    worst case time complexity is O(n^m*m) ( we need to consider substring action as well)
    space complexity is O(m*m)
     */
    private boolean solution(String target, String[] wordBank) {
        if ("".equals(target)) return true;

        for (String s : wordBank) {
            if (target.startsWith(s)) {
                String suffix = target.substring(s.length());
                if (solution(suffix, wordBank)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
        m = target.length
        n = wordBank.length
        Time complexity is O(n*m*m)
        Space complexity is O(m*m)
     */
    private boolean solution1(String target, String[] wordBank, Map<String, Boolean> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if ("".equals(target)) return true;

        for (String s : wordBank) {
            if (target.startsWith(s)) {
                String suffix = target.substring(s.length());
                if (solution1(suffix, wordBank, memo)) {
                    memo.put(target, true);
                    return memo.get(target);
                }
            }
        }
        memo.put(target, false);
        return memo.get(target);
    }


    @Test
    public void test1() {
        String target = "abcdef";
        String[] wordBank = {"ab", "abc", "cd", "def", "abcd"};
        System.out.println(solution1(target, wordBank, new HashMap<>()));//true
    }

    @Test
    public void test2() {
        String target = "skateboard";
        String[] wordBank = {"bo", "rd", "ate", "ska", "sk", "boar"};
        System.out.println(solution1(target, wordBank, new HashMap<>())); //false
    }

    @Test
    public void test3() {
        String target = "";
        String[] wordBank = {"cat", "dog", "mouse"}; //true
        System.out.println(solution1(target, wordBank, new HashMap<>()));//true
    }


}
