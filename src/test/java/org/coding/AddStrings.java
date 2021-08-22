package org.coding;

import org.junit.Test;

public class AddStrings {


    /*
    since long numbers cannot fit in integers, we need to do addition digit by digit.
    Iterate from last char -> convert that to digit -> add the integers -> have carry variable
    ex: "123" "99"
    carry = 0
    3 + 9 = 12, how do I get carry -> divide by 10 -> 12/10 = 1
    which number shoud go into result -> the last digit which is 2 -> 12 % 10 = 2
    If both numbers are equal, we can iterate from last index to 0 index of any digit.
    since both are different length, we should iterate either of the string has more chars to calculate
    finally add the carry if non zero
     */
    public String solution(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {

            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);

            i--;
            j--;
        }

        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    @Test
    public void test1() {
        String num1 = "6913259244";
        String num2 = "71103343";

        //output = "6984362587"

        System.out.println(solution(num1, num2));
    }


}
