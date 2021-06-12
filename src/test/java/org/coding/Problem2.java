package org.coding;

import org.junit.Test;

public class Problem2 {

    private String solution(String S){
        int i = 0;
        int j = S.length()-1;

        char[] charArray = S.toCharArray();

        while(i < j){

            if(charArray[i] != '?' && charArray[j] != '?'
                    && charArray[i] != charArray[j]){
                return "NO";
            }

            if(charArray[i] == '?' && charArray[j]  != '?'){
                charArray[i] = charArray[j];
            } else if(charArray[i] != '?' && charArray[j] == '?'){
                charArray[j] = charArray[i];
            } else {
                charArray[i] = 'a';
                charArray[j] = 'a';
            }

            i++;
            j--;
        }

        return String.valueOf(charArray);

    }

    @Test
    public void test1(){
        String s = "?ab??a";
        System.out.println(solution(s));//aabbaa
    }

    @Test
    public void test2(){
        String s = "bab??a";
        System.out.println(solution(s));//NO
    }

    @Test
    public void test3(){
        String s = "?a?";
        System.out.println(solution(s));
    }
}

