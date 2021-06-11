package org.coding;

public class MaxHeap {

    private int capacity;
    private int[] maxHeap;
    private int currentSize;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        maxHeap = new int[capacity + 1];
        currentSize = 0;
    }

    public void display() {
        for (int i = 0; i < heapSize(); i++) {
            System.out.print(maxHeap[i] + " ");
        }
        System.out.println();
    }


    public int peek() {
        return maxHeap[0];
    }

    public int heapSize() {
        return currentSize;
    }

    public void push(int e) {
        if (currentSize == capacity + 1) {
            throw new IllegalArgumentException("Heap is full...");
        }
        int idx = currentSize;
        maxHeap[idx] = e;
        currentSize++;
        bubbleUp(idx);
    }

    public int poll() {
        int max = maxHeap[0];
        maxHeap[0] = maxHeap[currentSize - 1];
        currentSize--;
        bubbleDown(0);
        return max;
    }

    public void bubbleUp(int position) {
        int currentIdx = position;
        int parentIdx = getParentIdx(position);
        while (parentIdx >= 0 && maxHeap[parentIdx] < maxHeap[currentIdx]) {
            swap(parentIdx, currentIdx);
            currentIdx = parentIdx;
            parentIdx = getParentIdx(parentIdx);
        }
    }

    public int getParentIdx(int position) {
        return position / 2;
    }

    public int getLeftChildIdx(int position) {
        return 2 * position + 1;
    }

    public int getRightChildIdx(int position) {
        return 2 * position + 2;
    }

    public void bubbleDown(int position) {
        int largest = position;
        int leftChildIdx = getLeftChildIdx(position);
        int rightChildIdx = getRightChildIdx(position);

        if (leftChildIdx < heapSize() && maxHeap[largest] < maxHeap[leftChildIdx]) {
            largest = leftChildIdx;
        }

        if (rightChildIdx < heapSize() && maxHeap[largest] < maxHeap[rightChildIdx]) {
            largest = rightChildIdx;
        }
        if (position != largest) {
            swap(largest, position);
            bubbleDown(largest);
        }
    }

    public void swap(int a, int b) {
        int temp = maxHeap[a];
        maxHeap[a] = maxHeap[b];
        maxHeap[b] = temp;
    }

    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.push(3);
        maxHeap.push(2);
        maxHeap.push(1);
        maxHeap.push(0);
        maxHeap.push(8);
        maxHeap.push(10);

        maxHeap.display();

        System.out.println(maxHeap.peek());

        System.out.println(maxHeap.poll());
        maxHeap.display();
        System.out.println(maxHeap.poll());
        maxHeap.display();
        System.out.println(maxHeap.poll());
        maxHeap.display();
        System.out.println(maxHeap.poll());
        maxHeap.display();
        System.out.println(maxHeap.poll());
        maxHeap.display();
        System.out.println(maxHeap.poll());
        maxHeap.display();



        int debug = 1;
    }
}
