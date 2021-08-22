package org.coding;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/unique-email-addresses/
public class UniqueEmailAddress {

    private int solution(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>(); //cost O(n) space
        for (String email : emails) {
            String[] emailParts = email.split("@");
            String[] localNameCombo = emailParts[0].split("\\+");
            String emailToBeSent = localNameCombo[0].replaceAll("\\.", "") + "@" + emailParts[1];
            uniqueEmails.add(emailToBeSent);
        }
        return uniqueEmails.size();
    }


    @Test
    public void test1() {
        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com"
                //1
        };
        System.out.println(solution(emails));
    }

    @Test
    public void test2() {
        String[] emails = {
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"
        };
        System.out.println(solution(emails));

        //2


    }


}
