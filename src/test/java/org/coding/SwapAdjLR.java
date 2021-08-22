package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/swap-adjacent-in-lr-string/
public class SwapAdjLR {

    //https://leetcode.com/problems/swap-adjacent-in-lr-string/discuss/873004/Easy-to-understand-explanation-with-PICTURE
    private boolean solution(String start, String end) {

        if (start.length() != end.length()) return false;
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;

        int i = 0;
        int j = 0;

        char[] sChars = start.toCharArray();
        char[] eChars = end.toCharArray();

        while (i < sChars.length && j < eChars.length) {

            while (i < sChars.length && sChars[i] == 'X') i++;
            while (j < eChars.length && eChars[j] == 'X') j++;

            //by
            if (i == sChars.length && j == eChars.length) return true;

            //for R -> R should be in the right in target string
            //i.e. j always higher than i. else case is false
            if (sChars[i] == 'R' && i > j) return false;

            //for L -> L should be in the left in target string
            //i.e. j always lesser than i. else case is false
            if (sChars[i] == 'L' && i < j) return false;
            i++;
            j++;
        }
        return true;
    }


    @Test
    public void test0() {
        String start = "LXXLXRLXXL";
        String end = "XLLXRXLXLX";
        System.out.println(solution(start, end));
        //false
    }

    @Test
    public void test1() {
        String start = "RXXLRXRXL";
        //  012345678
        String end = "XRLXXRRLX";
        //  012345678

        System.out.println(solution(start, end));
        //Output: true
        //Explanation: We can transform start to end following these steps:
        //RXXLRXRXL ->
        //XRXLRXRXL ->
        //XRLXRXRXL ->
        //XRLXXRRXL ->
        //XRLXXRRLX
    }

    @Test
    public void test2() {
        String start = "X";
        String end = "L";
        System.out.println(solution(start, end));
        //false
    }

    @Test
    public void test3() {
        String start = "LLR";
        String end = "RRL";
        System.out.println(solution(start, end));
        //false
    }

    @Test
    public void test4() {
        String start = "XL";
        String end = "LX";
        System.out.println(solution(start, end));
        //true
    }

    @Test
    public void test5() {
        String start = "XLLR";
        String end = "LXLX";
        System.out.println(solution(start, end));
        //false
    }

    @Test
    public void test6() {
        String start = "XXRXLXRXXX";
        String end = "XXRLXXXXXR";
        System.out.println(solution(start, end));
        //true
    }


}
