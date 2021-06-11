package org.coding;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://www.youtube.com/watch?v=jzZsG8n2R9A&t=494s
//https://www.youtube.com/watch?v=qJSPYnS35SE&t=231s
public class ThreeSum {

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
        List<List<Integer>> solution = solution(nums);
        System.out.println(solution);
        //Output = [-1, 0, 1] and [-1, -1, 2]
    }

    @Test
    public void test2() {
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> solution = solution(nums);
        System.out.println(solution);
        //Output = [0, 0, 0]
    }

    @Test
    public void test3() {
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> solution = solution(nums);
        System.out.println(solution);
        //Output = [-2,0,2]
    }


}
