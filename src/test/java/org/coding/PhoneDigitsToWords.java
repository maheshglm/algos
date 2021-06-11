package org.coding;


import org.junit.Test;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//https://www.youtube.com/watch?v=8EhxxkHzGew&t=1740s
public class PhoneDigitsToWords {


    private void solution(String s) {

    }

    private String getString(int d) {
        switch (d) {
            case 2:
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5:
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
            default:
                return "";
        }
    }

    @Test
    public void test1() {
        String s = "23";
        solution(s); //ad, ae, af, bd, be, bf, cd, ce, cf
    }

    @Test
    public void test2() {
        String s = "345";
        solution(s); //dgj, dgk, dgl,dhj, dhk, dhl etc......
    }
}
