package org.coding;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/string-to-integer-atoi/
//https://leetcode.com/problems/string-to-integer-atoi/solution/
public class StringToInteger {


    public int solution1(String s) {

        int index = 0;
        int sign = 1; //so we can multiply the number at the end
        int total = 0;

        //empty
        if (s.length() == 0) return 0;

        //remove spaces
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        //handle signs
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //convert number to avoid overflow
        while (index < s.length()) {
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) break;

            //handle overflow
            //test case 5
            boolean isResultOverflow = total > Integer.MAX_VALUE / 10;

            //test case 6
            boolean isAddingNextNumberOverflow =
                    (total == Integer.MAX_VALUE / 10
                            && digit > Integer.MAX_VALUE % 10);

            if (isResultOverflow || isAddingNextNumberOverflow) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = 10 * total + digit;
            index++;
        }

        return total * sign;


    }

    public int solution(String s) {
        int result = 0;
        int sign = 1; //positive

        if (s.length() == 0) return result;

        int i = 0;
        //find out first not white space char position
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        //check for the sign if it exists
        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        } else if (i < s.length() && !Character.isDigit(s.charAt(i))) {
            return 0;
        }

        //Build the result
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            //test case 5
            boolean isResultOverflow = result > Integer.MAX_VALUE / 10;

            //test case 6
            boolean isAddingNextNumberOverflow = result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10;

            if (isResultOverflow || isAddingNextNumberOverflow) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }


    @Test
    public void test1() {
        String s = "-42";
        Assert.assertEquals(-42, solution(s));
    }

    @Test
    public void test4() {
        String s = "    -42";
        Assert.assertEquals(-42, solution(s));
    }

    @Test
    public void test5() {
        String s = "-91283472332";
        Assert.assertEquals(-2147483648, solution(s));
        //The number "-91283472332" is out of the range of a 32-bit signed integer.
        // Therefore INT_MIN (−231) is returned.
    }


    @Test
    public void test2() {
        String s = "4193 with words";
        Assert.assertEquals(4193, solution(s));
    }

    @Test
    public void test3() {
        String s = "words and 987";
        Assert.assertEquals(0, solution(s));
    }

    @Test
    public void test6() {
        String s = "2147483648";
        Assert.assertEquals(2147483647, solution(s));
    }


}
