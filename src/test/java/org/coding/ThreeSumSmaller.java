package org.coding;

import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-smaller/
public class ThreeSumSmaller {

    /*
    Given an array of n integers nums and an integer target,
    find the number of index triplets i, j, k with 0 <= i < j < k < n
    that satisfy the condition nums[i] + nums[j] + nums[k] < target.
     */

    //https://leetcode.com/problems/3sum-smaller/discuss/68820/Accepted-and-Simple-Java-O(n2)-solution-with-detailed-explanation
    public int solution(int[] nums, int target) {
        int count = 0;

        Arrays.sort(nums);

        //no need to go to till end of array
        //if 6 numbers (length = 6),it can be taken till 3rd index
        //as 4th and 5th index can be for lo and hi as i < j < k

        //hi - lo is because:
        //see this scenario [1,2,3,5,8] and target 7
        //lo + hi = 1 + 8 = 9, since 9 > 7, will move hi--
        //lo + hi = 1 + 5 = 6, and 6 < 7. which means, how many pairs we can form ?
        //number of pairs between 1 and 5 -> 0th index and 3rd index -> 3 pairs
        for (int i = 0; i <= nums.length - 3; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < target) {
                    count += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return count;
    }

    @Test
    public void test1() {
        int[] nums = {-2, 0, 1, 3};
        int target = 2;
        //2
        //Explanation: Because there are two triplets which sums are less than 2:
        //[-2,0,1]
        //[-2,0,3]
        System.out.println(solution(nums, target));
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 3, 5, 8};
        int target = 9;
        System.out.println(solution(nums, target));
        //1,2, 5 and 1, 2, 3
    }

}
