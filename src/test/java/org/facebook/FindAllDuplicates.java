package org.facebook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=aMsSF1Il3IY&list=LL&index=2&t=679s
public class FindAllDuplicates {

    /* Given an array of integers 1 <= a[i] <= n,
    some elements appear twice and other appear once.
    Find all elements that appear twice.
    without extra space and in O(n) runtime.
     */

    private static List<Integer> solution(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= nums.length - 1; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(index + 1);
                //result.add(Math.abs(nums[i])]; is also works
            } else {
                nums[index] = -nums[index];
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(solution(nums));
        //Output = 2, 3
    }


}
