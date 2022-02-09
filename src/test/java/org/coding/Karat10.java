package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/discuss/interview-question/1251455/Indeed-or-Phone-Screen-or-Karat
public class Karat10 {

    /*
    We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order, and no URL was visited more than once per person.
    Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

    Sample input:

    user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
    user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
    user2 = ["a", "/one", "/two"]
    user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"]
    user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
    user5 = ["a"]
    user6 = ["/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"]

    Sample output:

    findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
    findContiguousHistory(user0, user2) => [] (empty)
    findContiguousHistory(user0, user0) => ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
    findContiguousHistory(user2, user1) => ["a"]
    findContiguousHistory(user5, user2) => ["a"]
    findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
    findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
    findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]

    n: length of the first user's browsing history
    m: length of the second user's browsing history
    */

    public List<String> solution(String[] user1, String[] user2) {
        return helper(user1, user2, 0, 0, new ArrayList<>());
    }

    private List<String> helper(String[] user1, String[] user2, int i, int j, List<String> result) {
        if (i >= user1.length || j >= user2.length) {
            return result;
        }

        if (user1[i].equals(user2[j])) {
            if (!result.contains(user1[i])) {
                result.add(user1[i]);
            }
            helper(user1, user2, i + 1, j + 1, result);
        }

        helper(user1, user2, i, j + 1, result);
        helper(user1, user2, i + 1, j, result);

        return result;
    }


    @Test
    public void test1() {
        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};
        String[] user2 = {"a", "/one", "/two"};
        String[] user3 = {"/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"};
        String[] user4 = {"/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"};
        String[] user5 = {"a"};
        String[] user6 = {"/pink", "/orange", "/six", "/plum", "/seven", "/tan", "/red", "/amber"};

        System.out.println(solution(user0, user1));
        System.out.println(solution(user1, user0));
        System.out.println(solution(user2, user5));
        System.out.println(solution(user6, user0));
        System.out.println(solution(user3, user4));

    }

}
