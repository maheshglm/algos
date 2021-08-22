package org.coding;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=v1HpZUnQ4Yo
//https://leetcode.com/problems/jump-game-vii/
public class JumpGameVII {

    //You are given a 0-indexed binary string s and two integers minJump and maxJump.
    // In the beginning, you are standing at index 0, which is equal to '0'.
    // You can move from index i to index j if the following conditions are fulfilled:
    //
    //i + minJump <= j <= min(i + maxJump, s.length - 1), and
    //s[j] == '0'.
    //Return true if you can reach index s.length - 1 in s, or false otherwise.

    /*
        BFS kind of approach
     */
    private boolean solution(String s, int minJump, int maxJump) {

        if (s.charAt(s.length() - 1) == '1') return false;

        //Q to maintain visited indices
        Queue<Integer> q = new LinkedList<>();
        //initially q is added first index i.e. 0
        q.add(0);

        int farthest = 0;
        while (!q.isEmpty()) {
            int curr_index = q.poll();
            //ideally start = curr_index + minJump
            //but what if we already crossed that point with farthest
            //farthest +1 means, next index after farthest
            //so it should be Max(farthest + 1, curr_index + minJump)

            int start = Math.max(farthest + 1, curr_index + minJump);
            ////ideally end = curr_index + maxJump
            //but what if we reached end already or out of bounce
            //so end = Min(nums.length-1, curr_index + maxJump)
            int end = Math.min(curr_index + maxJump, s.length() - 1);

            for (int i = start; i <= end; i++) {
                if (s.charAt(i) == '0') {
                    q.add(i);
                }
                if (i == s.length() - 1) return true;
            }
            farthest = curr_index + maxJump;
        }
        return false;
    }

    @Test
    public void test1() {
        String s = "011010";
        int min = 2;
        int max = 3;
        System.out.println(solution(s, min, max)); //true
    }
}

