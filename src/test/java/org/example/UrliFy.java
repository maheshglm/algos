package org.example;

import org.junit.Assert;
import org.junit.Test;

public class UrliFy {

    String solution1(String s) {
        return s.trim().replaceAll(" ", "%20");
    }

    @Test
    public void test1() {
        String string = "Mr John Smith    ";
        String expected = solution1(string);
        System.out.println(expected);
        Assert.assertEquals(expected, "Mr%20John%20Smith");
    }



    @Test
    public void test2() {
        String string = "Mr John Smith    ";

        String expected = solution1(string);
        System.out.println(expected);
        Assert.assertEquals(expected, "Mr%20John%20Smith");
    }
}
