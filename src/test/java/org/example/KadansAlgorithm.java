package org.example;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class KadansAlgorithm {

    private int maxSumWithStartAndEndingIndices(int[] a) {
        int max_sum = a[0];
        int current_sum = a[0];
        int start = 0;
        int end = 0;

        for (int i = 1; i <= a.length - 1; i++) {

            if (current_sum + a[i] > a[i]) {
                current_sum = current_sum + a[i];
            } else {
                current_sum = a[i];
                start = i;
            }

            if (max_sum < current_sum) {
                max_sum = current_sum;
                end = i;
            }
        }
        System.out.println("start " + start + " end " + end);
        return max_sum;
    }

    private int maxSum(int[] a) {
        int max_sum = a[0];
        int current_sum = a[0];

        for (int i = 1; i <= a.length - 1; i++) {
            current_sum = Math.max(current_sum + a[i], a[i]);
            max_sum = Math.max(max_sum, current_sum);
        }
        return max_sum;
    }

    private int kthMaxSum(int[] a, int k) {
        List<Integer> temp = new ArrayList<>();
        int current_sum = 0;

        int n = 0;
        while (n < a.length) {
            for (int i = n; i <= a.length - 1; i++) {
                current_sum = Math.max(current_sum + a[i], a[i]);
                temp.add(current_sum);
            }
            current_sum = 0;
            n++;
        }

        System.out.println(temp);
        return 1;
    }



    @Test
    public void test1() {
        int[] input = {-2, -3, -1};
        int i = maxSumWithStartAndEndingIndices(input);
        System.out.println(i);
    }

    @Test
    public void test2() {
        int[] input = {-2, -3, -1, -2, 1, 5, -3};
        Stopwatch stopwatch = Stopwatch.createStarted();
        int i = maxSumWithStartAndEndingIndices(input);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS) + " milli seconds");
        System.out.println(i);
    }

    //TODO inprogress
    @Test
    public void test3() {
        int[] a = {20, -5, -1};
        System.out.println(kthMaxSum(a, 3));

    }

    @Test
    public void test4() {
        int[] a = {1, 2, 3};
        
    }


}
