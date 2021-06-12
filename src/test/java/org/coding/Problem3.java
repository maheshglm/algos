package org.coding;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {

    public int solution(String S) {

        for(int j = 1; j <= S.length(); j++){
            for(int i = 0; i < S.length()-j+1; i++){
                Set<Character> lower_case_letters = new HashSet();
                Set<Character> upper_case_letters = new HashSet();

                String sub = S.substring(i, i+j);

                for(char c: sub.toCharArray()){
                    if(Character.isLowerCase(c)){
                        lower_case_letters.add(c);
                    } else {
                        upper_case_letters.add(c);
                    }
                }

                if(containsAllElements(lower_case_letters, upper_case_letters)
                        && containsAllElements(upper_case_letters, lower_case_letters)){
                    return sub.length();
                }
            }
        }

        return -1;
    }

    static int getShortestFragment(String str){
        for(int k=1;k<=str.length();k++){
            for(int i=0;i<str.length()-k+1;i++){
                Set<Character> lowerSet = new HashSet<>();
                Set<Character> upperSet = new HashSet<>();
                String temp = str.substring(i,i+k);
                char[] tempCharArr = temp.toCharArray();
                for(char ch : tempCharArr){
                    if(Character.isLowerCase(ch))
                        lowerSet.add(ch);
                    else
                        upperSet.add(ch);
                }
                if(containsAllElements(lowerSet, upperSet) && containsAllElements(upperSet, lowerSet)){
                    return temp.length();
                }
            }
        }
        return -1;
    }

    static boolean containsAllElements(Set<Character> first, Set<Character> second){
        Set<Character> temp1 = new HashSet();
        Set<Character> temp2 = new HashSet();
        for(char c : first){
            temp1.add(Character.toLowerCase(c));
        }
        for(char c : second){
            temp2.add(Character.toLowerCase(c));
        }

        return temp1.containsAll(temp2);
    }

    @Test
    public void test1(){
        String s = "AcZCbaBz";
        System.out.println(solution(s));
        System.out.println(getShortestFragment(s));
    }
}
