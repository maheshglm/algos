package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ActivateFountain {

    private static int solution(List<Integer> locations) {
        int n = locations.size();
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min = Math.max(i - locations.get(i - 1), 1);
            int max = Math.min(i + locations.get(i - 1), n);
            System.out.println(min + " " + max);
            for (int j = min; j < max; j++) {
                arr[j] = Math.max(arr[j], max);
            }
        }

        int result = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, i+arr[i]);
            if(i == arr[0]){
                result++;
                arr[0] = max;
            }
        }



        System.out.println(result);
        return -1;
    }

    @Test
    public void test1() {
        List<Integer> input = Arrays.asList(2, 0,0,0);
        solution(input);
    }

}
