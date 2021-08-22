package org.coding;

import org.junit.Test;

import java.util.Stack;

//https://leetcode.com/problems/remove-k-digits/solution/
//https://www.youtube.com/watch?v=vbM41Zql228
public class RemoveKDigits {


    //Intuition A=1axxxx, B=1bxxxx, if a > b then A > B
    //if we iterate from left to right more a digit left hand side and more weight it carries
    //compare each digit with left neighbour
    //Given a sequence of digits [D1, D2, D3...Dn]
    //if D2 < D1 => then we should remove left neighbour i.e. D1 to maintain minimum number
    //more corner cases
    //k == len of string ex: num "1" and k = 1, return should be "0"
    //when number is like 1111 where there is no increasing sequence observed
    //in that case just pop k times
    //another case with leading zeros like 10200 , k=1 => 0200, we should trim all zeros.
    private String solution(String num, int k) {
        Stack<Character> stack = new Stack<>();

        //corner case
        if (k == 0) return num;
        if (k == num.length()) return "0";

        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        //corner case 2) like no increasing sequence
        //1111  and k = 2 or 112 k=1
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        //remove all zeros at the end cannot use regexp, coz of test4
        //return sb.reverse().toString().replaceFirst("^0*", "");

        //it handle another corner case like "10" and k=1, the output has to be  "0"
        //remove all the 0 at the head
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0')
            sb.deleteCharAt(sb.length() - 1);

        return sb.reverse().toString();
    }


    @Test
    public void test0() {
        String num = "112";
        int k = 1;
        System.out.println(solution(num, k));
        //11
    }

    @Test
    public void test1() {
        String num = "1432219";
        int k = 3;
        System.out.println(solution(num, k));
        //output = 1219 by removing 2 4 3
    }

    @Test
    public void test2() {
        String num = "10200";
        int k = 1;
        System.out.println(solution(num, k));
        //output = 200 by removing leading 1
    }

    @Test
    public void test3() {
        String num = "10";
        int k = 2;
        System.out.println(solution(num, k));
        //output = 0 by removing all digits
    }

    @Test
    public void test4() {
        String num = "10";
        int k = 1;
        System.out.println(solution(num, k));
        //output = 0 by removing all digits
    }

}
