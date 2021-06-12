package org.coding;

import com.google.common.base.Strings;
import org.junit.Test;

public class StringReversal {

    //reverse string and revert each word
    String solution1(final String str) {
        char[] newChar = new char[str.length()];
        int j = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            newChar[j++] = str.charAt(i);
        }
        return String.valueOf(newChar);
    }

    void stringRev(String s) {
        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        char temp;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }

    }

    String solution2(final String str) {
        if (Strings.isNullOrEmpty(str) || str.length() == 1) {
            return str;
        }

        stringRev(str);

        System.out.println(str);

        return str;
    }


    @Test
    public void test1() {
        String s = "Hello World";
        String expected = "dlroW olleH";
        String expected1 = "World Hello";

        solution2(s);
    }
}
