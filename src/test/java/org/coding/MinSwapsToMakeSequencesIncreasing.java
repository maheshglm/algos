package org.coding;

import org.junit.Test;

//https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/161887/Bottom-up-DP-with-Optimization-(Java-Python)
//https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
//https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/discuss/119879/JavaC%2B%2BPython-DP-O(N)-Solution
public class MinSwapsToMakeSequencesIncreasing {


    /*
    for(int i = 1; i < n; i++) {
        if(A[i - 1] < A[i] && B[i - 1] < B[i]) {
            swap[i] = swap[i - 1] + 1; //swap both A[i - 1], B[i - 1] & A[i], B[i]
            not_swap[i] = not_swap[i - 1]; //don't swap both A[i - 1], B[i - 1] & A[i], B[i]
        }
        if(A[i] > B[i - 1] && B[i] > A[i - 1]) {
            swap[i] = Math.min(swap[i], not_swap[i - 1] + 1); //if we swap A[i],B[i], we don't need to swap A[i - 1],B[i - 1]
            //not_swap[i - 1] + 1 because we didn't swap A[i - 1] & B[i - 1] and +1 for current swap
            not_swap[i] = Math.min(not_swap[i], swap[i - 1]); //if we swap A[i - 1],B[i - 1], we don't need to swap A[i],B[i]
        }
    }
     */
    public int solution1(int[] A, int[] B) {
        int N = A.length;
        int[] swap = new int[1000];
        int[] not_swap = new int[1000];
        swap[0] = 1;


        for (int i = 1; i < N; ++i) {
            not_swap[i] = swap[i] = N;

            if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
                // swap both A[i - 1], B[i - 1] & A[i], B[i]
                swap[i] = swap[i - 1] + 1;

                // don't swap both A[i - 1], B[i - 1] & A[i], B[i]
                not_swap[i] = not_swap[i - 1];
            }
            if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
                ///if we swap A[i],B[i], we don't need to swap A[i - 1],B[i - 1]
                // not_swap[i - 1] + 1 because we didn't swap A[i - 1] & B[i - 1] and +1 for current swap
                swap[i] = Math.min(swap[i], not_swap[i - 1] + 1);

                //if we swap A[i - 1],B[i - 1], we don't need to swap A[i],B[i]
                not_swap[i] = Math.min(not_swap[i], swap[i - 1]);
            }
        }
        return Math.min(swap[N - 1], not_swap[N - 1]);
    }


    public int solution(int[] A, int[] B) {
        int n = A.length, prevNotSwap = 0, prevSwap = 1;

        for (int i = 1; i < n; i++) {
            boolean areBothSelfIncreasing = A[i - 1] < A[i] && B[i - 1] < B[i];
            boolean areInterchangeIncreasing = A[i - 1] < B[i] && B[i - 1] < A[i];

            if (areBothSelfIncreasing && areInterchangeIncreasing) {
                int newPrevNotSwap = Math.min(prevNotSwap, prevSwap);
                prevSwap = Math.min(prevNotSwap, prevSwap) + 1;
                prevNotSwap = newPrevNotSwap;
            } else if (areBothSelfIncreasing) {
                prevSwap++;
            } else { // if (areInterchangeIncreasing)
                int newPrevNotSwap = prevSwap;
                prevSwap = prevNotSwap + 1;
                prevNotSwap = newPrevNotSwap;
            }
        }

        return Math.min(prevSwap, prevNotSwap);
    }

    @Test
    public void test1() {
        int[] A = {1, 3, 5, 4};
        int[] B = {1, 2, 3, 7};
        System.out.println(solution(A, B));
        /*
        Output: 1
        Explanation:
        Swap nums1[3] and nums2[3].  Then the sequences are:
        nums1 = [1, 3, 5, 7] and nums2 = [1, 2, 3, 4]
        which are both strictly increasing.
         */
    }


}
