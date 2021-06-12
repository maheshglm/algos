package org.coding;

import org.junit.Test;

public class ChatArrayToInt {

    @Test
    public void test1() {
        char[] nums = {'1', '2', '3'};
        int result = 0;
        for (char num : nums) {
            int digit = num - '0';
            result = result * 10;
            result = result + digit;
        }
        int increment = result + 1;
        System.out.println(increment);
    }
}
