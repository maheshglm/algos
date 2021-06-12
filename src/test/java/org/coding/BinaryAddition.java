package org.coding;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryAddition {

    //recommended approach
    private static String solution2(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int sum;
        while (i >= 0 || j >= 0) {

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

    }

    @Test
    public void test2() {
        String s1 = "11";
        String s2 = "1";

        String expected = "100";

        Assert.assertEquals(expected, solution2(s1, s2));
        Assert.assertEquals(expected, solution(s1, s2));
    }

    @Test
    public void test3() {
        String s1 = "11";
        String s2 = "11";

        String expected = "110";

        Assert.assertEquals(expected, solution2(s1, s2));
        Assert.assertEquals(expected, solution(s1, s2));
    }
}
