package org.coding;

import org.junit.Test;

//https://www.youtube.com/watch?v=vbM41Zql228
public class RemoveKDigitsPending {


    @Test
    public void test1() {
        int num = 1432219;
        int k = 3;
        //output = 1219 by removing 2 4 3

    }

    @Test
    public void test2() {
        int num = 10200;
        int k = 1;
        //output = 200 by removing leading 1
    }

    @Test
    public void test3() {
        int num = 10;
        int k = 2;
        //output = 0 by removing all digits
    }

}
