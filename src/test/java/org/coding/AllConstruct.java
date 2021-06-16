package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AllConstruct {

     /*
   Function should return 2D array of all the ways the 'target'
   can be constructed by concatenating elements of the 'wordBank' array
   Reuse elements is allowed.
   Hint: for empty target string answer is true as with no words we can make empty target
    */

    public List<List<String>> solution(String target, String[] wordBank) {
        if ("".equals(target)) return Collections.singletonList(new ArrayList<>());

        List<List<String>> result = new ArrayList<>();

        for (String word : wordBank) {
            if (target.startsWith(word)) {
                String sub = target.substring(word.length());
                List<List<String>> suffixWays = solution(sub, wordBank);
                suffixWays.forEach(a -> a.add(0, word));
                result.addAll(suffixWays);
            }
        }
        return result;
    }

    @Test
    public void test1(){
        String target = "purple";
        String[] wordBank = {"purp", "p", "ur", "le", "purpl"};
        System.out.println(solution(target, wordBank));
    }

}
