package org.coding;

import org.junit.Test;

import java.util.*;

//https://leetcode.com/problems/number-of-atoms/
public class NumberOfAtoms {


    private String solution(String formula) {

        return "";
    }


    @Test
    public void test1() {
        String formula = "H2O";
        //out H2O
        //Explanation: The count of elements are {'H': 2, 'O': 1}.
    }

    @Test
    public void test2() {
        String formula = "Mg(OH)2";
        //out H2MgO2
        //Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
    }

    @Test
    public void test3() {
        String formula = "K4(ON(SO3)2)2";
        //out K4N2O14S4
        //Explanation: The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}.
    }

}
