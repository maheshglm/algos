package org.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryAddition {


    //O(N + M) time
    //drawback is if length is large, integer cannot hold,
    //so bit by bit computation is better
    private String solution3(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        return Integer.toBinaryString(num1 + num2);
    }

    //O(max(N, M))
    //space O(max(N, M))
    //recommended approach
    //Similar to Integer string addition AddStrings.java
    //since these binary numbers, we should use base 2 instead of base 10,
    //for calculating carry and result
    private String solution2(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int sum;
        while (i >= 0 || j >= 0) {

            //2 different ways to get number from character
            int digit1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? Character.getNumericValue(b.charAt(j)) : 0;

            sum = carry + digit1 + digit2;

            sb.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    private static class Result {
        char result;
        char carry;

        public Result(char result, char carry) {
            this.result = result;
            this.carry = carry;
        }
    }

    private static String solution(String binary1, String binary2) {

        StringBuilder sb = new StringBuilder();

        int i = binary1.length() - 1;
        int j = binary2.length() - 1;
        char carry = 0;

        while (i >= 0 || j >= 0) {
            List<Character> chars = new ArrayList<>();
            chars.add(carry);

            if (i >= 0) chars.add(binary1.charAt(i--));
            if (j >= 0) chars.add(binary2.charAt(j--));

            Result result = getAddResult(chars);
            sb.append(result.result);
            carry = result.carry;
        }
        return sb.append(carry).reverse().toString();
    }

    private static Result getAddResult(List<Character> chars) {
        long onesCount = chars.stream().filter(c -> c.equals('1')).count();
        if (onesCount == 1) {
            return new Result('1', '0');
        } else if (onesCount == 2) {
            return new Result('0', '1');
        } else if (onesCount == 3) {
            return new Result('1', '1');
        }
        return new Result('0', '0');
    }

    @Test
    public void test1() {
        String s1 = "101101";
        String s2 = "111101";

        String expected = "1101010";
        Assert.assertEquals(expected, solution2(s1, s2));
        Assert.assertEquals(expected, solution(s1, s2));
        Assert.assertEquals(expected, solution3(s1, s2));
    }

    @Test
    public void test2() {
        String s1 = "11";
        String s2 = "1";

        String expected = "100";

        Assert.assertEquals(expected, solution2(s1, s2));
        Assert.assertEquals(expected, solution(s1, s2));
        Assert.assertEquals(expected, solution3(s1, s2));
    }

    @Test
    public void test3() {
        String s1 = "11";
        String s2 = "11";

        String expected = "110";

        Assert.assertEquals(expected, solution2(s1, s2));
        Assert.assertEquals(expected, solution(s1, s2));
        Assert.assertEquals(expected, solution3(s1, s2));
    }
}
