package org.coding;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
public class LRUCache {

    class Node {
        Node prev;
        Node next;
        int key, value;
    }

    Node head = new Node();
    Node tail = new Node();

    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }

    public void add(Node n) {
        Node headNext = head.next;

        head.next = n;
        n.prev = head;

        headNext.prev = n;
        n.next = headNext;
    }

    public void remove(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            remove(curr);
            add(curr);
            return curr.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node curr = map.get(key);
            remove(curr); //the reason is we want to keep it active i.e. need to push this to the front
            curr.value = value;//so we are removing and adding again
            add(curr);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node node = new Node();
            node.key = key;
            node.value = value;
            map.put(key, node);
            add(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1); // cache is {2=1}
        lRUCache.get(2); //1
        lRUCache.put(3, 2); // cache is {3=2}
        lRUCache.get(2); //-1
        lRUCache.get(3); //2
    }


    //@Test
    public void test1() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }

    // @Test
    public void test2() {
        LRUCache lRUCache = new LRUCache(1);
        lRUCache.put(2, 1); // cache is {2=1}
        lRUCache.get(2); //1
        lRUCache.put(3, 2); // cache is {3=2}
        lRUCache.get(2); //-1
        lRUCache.get(3); //2
    }

}


