package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//https://leetcode.com/problems/find-the-most-competitive-subsequence/solution/
//https://www.youtube.com/watch?v=GBJFxSD3B_s
//https://leetcode.com/problems/find-the-most-competitive-subsequence/
public class CompetitiveSubsequence {


    private int[] solution1(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {

//            int remainingElements = k - stack.size();
//            int elementInArray = nums.length - i;
//            elements in array to be processed is greater than remaining elements

            while (!stack.isEmpty() && nums[i] < stack.peek()
                    && nums.length - i > k - stack.size()) {
                stack.pop();
            }

            if (stack.size() < k) {
                stack.push(nums[i]);
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    //Competitive Subsequence means the sub sequence arranged in increasing order (general case)
    //ex: 3 6 4 2 1 k=3
    //i = 0, insert 3 into Queue - remaining positions k-1 = 2
    //i = 1, num = 6, 3 < 6 -> insert 6 at the last - remaining positions k-2 = 1
    //i = 2, num = 4, 6 < 4 -> deque 6 and insert 4 at the last - remaining positions k-2 = 1
    //i = 3, num = 2, 4 < 2 -> deque 4 and insert 2 at the last - remaining positions k-2 = 1
    //i = 4, num = 1, 2 < 1 -> remaining positions k-3 = 0, since the count is zero. we cannot move next.
    //result is 3 2 1
    //O(N), and O(N)

    //smallest among all subsequences
    //[2, 3, 4] - (2, 3), (2, 4) and (3, 4)
    //among 3 subsequences - (2, 3) is smallest as compared to 0th index and 1st index of all elements
    private int[] solution(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();

        int additionalCount = nums.length - k;

        for (int num : nums) {
            while (!queue.isEmpty()
                    && queue.peekLast() > num
                    && additionalCount > 0) {
                queue.pollLast();
                additionalCount--;
            }
            queue.addLast(num);
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = queue.pollFirst();
        }
        return result;
    }


    @Test
    public void test0() {
        int[] nums = {3, 6, 4, 2, 1};
        int k = 3;
        System.out.println(Arrays.toString(solution(nums, k)));
        System.out.println(Arrays.toString(solution1(nums, k)));

    }

    @Test
    public void test1() {
        int[] nums = {3, 5, 2, 6};
        int k = 2;
        System.out.println(Arrays.toString(solution(nums, k)));
        System.out.println(Arrays.toString(solution1(nums, k)));

        //Output: [2,6]
        //Explanation: Among the set of every possible subsequence:
        //{[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]},
        // [2,6] is the most competitive.
    }

    @Test
    public void test2() {
        int[] nums = {2, 4, 3, 3, 5, 4, 9, 6};
        int k = 4;
        System.out.println(Arrays.toString(solution(nums, k)));
        System.out.println(Arrays.toString(solution1(nums, k)));
        //Output: [2,3,3,4]
    }


}
