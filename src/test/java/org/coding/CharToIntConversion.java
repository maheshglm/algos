package org.coding;

import org.junit.Test;

public class CharToIntConversion {

    public char[] solution(char[] chars, int addNumber) {
        int num = Integer.parseInt(new String(chars));
        int newNum = num + addNumber;
        return String.valueOf(newNum).toCharArray();
    }

//    public char[] solution1(char[] chars, int addNumber) {
//
//    }

    private int convertCharToInt(Character c) {
        return c - '0';
    }

    @Test
    public void test1() {
        String s = "1234";
        char[] chars = s.toCharArray();
        char[] solution = solution(chars, 1);
        //System.out.println(solution);
        //output = 1235 in char array

        char c1 = '1';

        System.out.println(c1 + 1); //50 (49 + 1)
        System.out.println(Character.getNumericValue(c1) + 1); //2
        System.out.println(c1 - '0' + 1); //2
        System.out.println(String.valueOf(c1) + 1); //11

        int n1 = 2;
        System.out.println(n1);

    }
}
