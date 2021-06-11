package org.coding;

public class MinHeap {

    public int capacity;
    public int currentSize;
    public int[] minHeap;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        minHeap = new int[capacity + 1];
        this.currentSize = 0;
    }

    public void push(int e) {
        if (currentSize == capacity + 1) {
            throw new IllegalArgumentException("Heap is full");
        }
        int idx = currentSize;
        minHeap[idx] = e;
        currentSize++;
        bubbleUp(idx);
    }

    public void display() {
        for (int i = 0; i < heapSize(); i++) {
            System.out.print(minHeap[i] + " ");
        }
        System.out.println();
    }

    private int getParentIdx(int position) {
        return (position - 1) / 2;
    }

    private int getLeftChildIdx(int position) {
        return 2 * position + 1;
    }

    private int getRightChildIdx(int position) {
        return 2 * position + 2;
    }

    public void bubbleUp(int position) {
        int parentIdx = getParentIdx(position);
        int currentIdx = position;
        while (currentIdx > 0 && minHeap[parentIdx] > minHeap[currentIdx]) {
            swap(parentIdx, currentIdx);
            currentIdx = parentIdx;
            parentIdx = getParentIdx(parentIdx);
        }
    }

    public void bubbleDown(int k) {
        int smallest = k;
        int leftChildIdx = getLeftChildIdx(k); //2*i + 1
        int rightChildIdx = getRightChildIdx(k); //2*i + 2

        if (leftChildIdx < heapSize() && minHeap[smallest] > minHeap[leftChildIdx]) {
            smallest = leftChildIdx;
        }

        if (rightChildIdx < heapSize() && minHeap[smallest] > minHeap[rightChildIdx]) {
            smallest = rightChildIdx;
        }

        if (smallest != k) {
            swap(smallest, k);
            bubbleDown(smallest);
        }
    }

    public int heapSize() {
        return currentSize;
    }

    void swap(int a, int b) {
        int temp = minHeap[a];
        minHeap[a] = minHeap[b];
        minHeap[b] = temp;
    }


    public int poll() {
        int min = minHeap[0];
        minHeap[0] = minHeap[currentSize - 1];
        bubbleDown(0);
        currentSize--;
        return min;
    }

    public int peek() {
        return minHeap[0];
    }

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(4);
        minHeap.push(3);
        minHeap.push(2);
        minHeap.push(1);
        minHeap.push(0);
        minHeap.push(8);
//        minHeap.push(4);
//        minHeap.push(10);
//        minHeap.push(16);
//        minHeap.push(12);

        minHeap.display();

        System.out.println(minHeap.poll());
        minHeap.display();
        System.out.println(minHeap.poll());
        minHeap.display();
        System.out.println(minHeap.poll());
        minHeap.display();


        int debug = 1;
    }


}
