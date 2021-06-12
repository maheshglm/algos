package org.coding;

import org.junit.Test;

public class AddStrings {


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
