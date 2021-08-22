package org.coding;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://www.youtube.com/watch?v=jzZsG8n2R9A&t=494s
//https://www.youtube.com/watch?v=qJSPYnS35SE&t=231s
public class ThreeSum {

    //same solution but in easy way
    private List<List<Integer>> solution1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        //Let iterate till element is less than or equal to 0.
        //by gng further does not make sum zero as further wll have positive numbers
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            //no need to repeat the checking if it is same value
            //ex: -1, -1, 0, 1
            //the result will be same for -1, so after processing -1 first time,
            //we can skip same value
            //and skipping should start from when i = 1;
            if (i == 0 || nums[i - 1] != nums[i]) {
                //call twosum function now
                twoSum(nums, result, i);
            }
        }
        return result;
    }

    //while summing, we ll include ith element in the summation by default
    //and include i+1 element and last element in the sum
    //based on sum result (i.e. less than zero or greater than zero), we ll increment or decrement lo and hi
    private void twoSum(int[] nums, List<List<Integer>> result, int index) {
        int lo = index + 1;
        int hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[index] + nums[lo] + nums[hi];
            if (sum < 0) {
                lo++;
            } else if (sum > 0) {
                hi--;
            } else {
                //now sum = 0
                //so add the triplet to the list
                //and increment lo and decrement hi
                result.add(Arrays.asList(nums[index], nums[lo], nums[hi]));
                lo++;
                hi--;
                //to avoid duplicate sets in the result
                //ex: 0, 0, 0, 0, 0
                //result will have 0th, 1st and 4th index
                //when lo++ and hi--, lo points to 2nd index and hi points to 3rd index
                //since the result is same for this pair as well, we ll increment lo with validating another zero
                //another example is -2, 0, 0, 2, 2
                //first pair is -2, 0, 2, to skip another zero, we ll increment lo
                while (lo < hi && nums[lo] == nums[lo - 1]) {
                    lo++;
                }
            }
        }
    }

    //Triplets that sum to zero
    private List<List<Integer>> solution(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            //this if condition is to avoid duplicate
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum > 0) {
                        high--;
                    } else if (sum < 0) {
                        low++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        //this is to handle 2nd and 3rd case.
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        low++;
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
        //Output = [-1, 0, 1] and [-1, -1, 2]
    }

    @Test
    public void test2() {
        int[] nums = {0, 0, 0, 0};
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
        //Output = [0, 0, 0]
    }

    @Test
    public void test3() {
        int[] nums = {-2, 0, 0, 2, 2};
        System.out.println(solution(nums));
        System.out.println(solution1(nums));
        //Output = [-2,0,2]
    }


}
