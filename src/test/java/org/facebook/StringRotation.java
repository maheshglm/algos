package org.facebook;

import org.junit.Test;

//https://www.java67.com/2017/07/string-rotation-in-java-write-program.html
public class StringRotation {

    private boolean solution1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return (s1 + s1).indexOf(s2) >= 1;
    }

    private boolean solution(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            count++;
            if (s2.equals(s1.substring(i + 1) + s1.substring(0, i + 1))) {
                System.out.println("Rotation occurred at " + count + " char rotations");
                return true;
            }
        }
        return false;
    }

    @Test
    public void test1() {
        String s1 = "IndiaUSAEngland";
        String s2 = "USAEnglandIndia";
        System.out.println(solution(s1, s2)); //true
        System.out.println(solution1(s1, s2)); //true
    }

    @Test
    public void test2() {
        String s1 = "IndiaUSAEngland";
        String s2 = "IndiaEnglandUSA";
        System.out.println(solution(s1, s2)); //false
        System.out.println(solution1(s1, s2)); //false
    }
}
