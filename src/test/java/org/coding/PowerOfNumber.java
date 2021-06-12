package org.coding;

import org.junit.Test;

public class PowerOfNumber {

    private int solution(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        int temp = solution(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    @Test
    public void test1() {
        int x = 2;
        int n = 5;
        //result 2 ^ 5 = 32;

        System.out.println(solution(x, n));


    }

}
