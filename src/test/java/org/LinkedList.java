package org;

//https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
public class LinkedList<T> {

    public ListNode<T> head;

    public static class ListNode<T> {
        public T data;
        public ListNode<T> next;

        //public variables can be replaced by getters

        public ListNode(T data) {
            this.data = data;
        }

        public ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public ListNode<T> insert(T data) {
        ListNode<T> new_node = new ListNode<T>(data);
        new_node.next = null;

        //if the list is empty
        if (head == null) {
            head = new_node;
        } else {
            ListNode<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return head;
    }

    public void print() {

        ListNode<T> curr_node = head;

        if (curr_node == null) {
            System.out.println("No elements in the Linked List");
            return;
        }

        while (curr_node != null) {
            System.out.print(curr_node.data + " ");
            curr_node = curr_node.next;
        }
        System.out.println();
    }

    public void print(ListNode node) {

        ListNode<T> curr_node = node;

        if (curr_node == null) {
            System.out.println("No elements in the Linked List");
            return;
        }

        while (curr_node != null) {
            System.out.print(curr_node.data + " ");
            curr_node = curr_node.next;
        }
        System.out.println();
    }

    public ListNode<T> delete(T data) {
        ListNode<T> curr_node = head;

        //If head node itself is the ket to be deleted
        if (curr_node != null && curr_node.data == data) {
            head = curr_node.next;
            System.out.println("Data " + data + " to be deleted found at head");
            return head;
        }

        ListNode<T> prev = null;
        //Traverse thru all nodes until find a match
        while (curr_node != null && curr_node.data != data) {
            prev = curr_node;
            curr_node = curr_node.next;
        }

        if (curr_node != null) {
            prev.next = curr_node.next;
            System.out.println("Data " + data + " found and deleted");
        } else {
            System.out.println("Data " + data + " not found");
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.insert(1);
        list.insert(2);
        list.insert(5);
        list.insert(10);
        list.insert(20);
        list.insert(6);

        list.print();

        list.delete(2);

        list.print();


    }


}
