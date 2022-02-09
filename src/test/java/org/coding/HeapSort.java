package org.coding;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSort {

    //using Priority Queue - Default Order which is Ascending order
    private void solution1(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length);
        for (int num : nums) {
            pq.add(num);
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }

    //using Priority Queue - Reverse Order which is Descending order
    private void solution2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length, Comparator.reverseOrder());
        for (int num : nums) {
            pq.add(num);
        }

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }

    //Using Arrays
    private void solution(int[] nums) {
        int size = nums.length;

        //size-1/2 is because no under heapify, the right child will be calculated
        //as 2i+2, even if we start from size-1 index, we ll not have right child. because
        //assume i = 6, the right child indx will be 2*6+2 = 14 which is not possible,
        //if I chose size/2 -1=> 7/2-1 => 2, the right index will be 2*2+2 => 6 is valid index to heapify

        //Below for loop builds heap.
        //Building heap does not mean that it wil be in sorting order
        //So this loop just builds the heap
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(nums, size, i);
        }

        //swap each element with with 0 and heapify again
        //by heapify again largest will go on top and swap will be replace that with smallest
        for (int n = size - 1; n > 0; n--) {
            int temp = nums[0];
            nums[0] = nums[n];
            nums[n] = temp;
            heapify(nums, n, 0);
        }
    }

    private void heapify(int[] arr, int heapSize, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != root) {
            int temp = arr[root];
            arr[root] = arr[largest];
            arr[largest] = temp;
            heapify(arr, heapSize, largest);
        }
    }

    @Test
    public void test1() {
        int[] nums = {9, 10, 5, 3, 1, 2, 6};
        //Output - [1, 2, 3, 5, 6, 9, 10]

        solution1(nums);
        System.out.println();
        solution2(nums);
        solution(nums);

        int debug = 1;
    }

}
