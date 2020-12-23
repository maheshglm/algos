package org.facebook;

import org.junit.Assert;
import org.junit.Test;

public class StringHasUniqueChars {

    private boolean solution1(String s) {
        boolean[] charSet = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charSet[c]) {
                return false;
            }
            charSet[c] = true;
        }
        return true;
    }

    private boolean solution2(String s) {
        int[] charSet = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charSet[c] == '1') {
                return false;
            }
            charSet[c] = '1';
        }
        return true;
    }

    @Test
    public void test1() {
        String s = "Mahesh";
        boolean b = solution1(s);
        boolean b1 = solution2(s);
        Assert.assertFalse(b);
        Assert.assertFalse(b1);
    }

    @Test
    public void test2() {
        String s = "Mahes";
        boolean b = solution1(s);
        boolean b1 = solution2(s);
        Assert.assertTrue(b);
        Assert.assertTrue(b1);
    }
}
