package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/subdomain-visit-count/
public class Karat8 {

    /*
    A website domain "discuss.leetcode.com" consists of various subdomains.
    At the top level, we have "com", at the next level,
    we have "leetcode.com" and at the lowest level, "discuss.leetcode.com".
    When we visit a domain like "discuss.leetcode.com",
    we will also visit the parent domains "leetcode.com" and "com" implicitly.

    A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2"
    where rep is the number of visits to the domain and d1.d2.d3 is the domain itself.

    For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited 9001 times.
    Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the input.
    You may return the answer in any order.
     */
    private List<String> solution(String[] domains) {
        List<String> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (String domain : domains) {
            String[] domainC = domain.split(" ");
            map.put(domainC[1], map.getOrDefault(domainC[1], 0) + Integer.parseInt(domainC[0]));
            int subC = domainC[1].indexOf(".");
            String s = domainC[1];
            while (subC >= 0) {
                String subD = s.substring(subC + 1);
                map.put(subD, map.getOrDefault(subD, 0) + Integer.parseInt(domainC[0]));
                subC = subD.indexOf(".");
                s = subD;
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.toString());
        }
        return result;
    }


    @Test
    public void test1() {
        String[] countDomains = {
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
        };

        System.out.println(solution(countDomains));
        /*
        Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
        Explanation: We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, "intel.mail.com" once and "wiki.org" 5 times.
        For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 50 + 1 = 951 times, and "org" 5 times.
         */
    }

}
