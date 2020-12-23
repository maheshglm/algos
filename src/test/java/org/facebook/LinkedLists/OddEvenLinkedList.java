package org.facebook.LinkedLists;


import org.LinkedList;
import org.LinkedList.ListNode;
import org.junit.Test;

//https://www.youtube.com/watch?v=C_LA6SOwVTM&list=PLU_sdQYzUj2keVENTP0a5rdykRSgg9Wp-&index=19
public class OddEvenLinkedList {

    private ListNode<Integer> solution(ListNode<Integer> head) {
        if (head == null) {
            return null;
        }

        //Create 2 individual lists for odd and even and establish the link between both

        ListNode odd = head;
        ListNode even = head.next;

        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return odd;
    }


    @Test
    public void test1() {
        LinkedList<Integer> list1 = new LinkedList<>();
        ListNode<Integer> head = list1.insert(1);
        list1.insert(2);
        list1.insert(3);
        list1.insert(4);
        list1.insert(5);

        //print = 1 -> 2 -> 3 -> 4 -> 5

        //odd number nodes should come first and even numbers next
        //output = 1 -> 3 -> 5 -> 2 -> 4

        solution(head);

        list1.print();
    }

    @Test
    public void test2() {
        LinkedList<Integer> list1 = new LinkedList<>();
        ListNode<Integer> head = list1.insert(2);
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);
        list1.insert(6);
        list1.insert(4);
        list1.insert(7);

        //print = 2 -> 1 -> 3 -> 5 -> 6 -> 4 ->7

        //odd number nodes should come first and even numbers next
        //output = 2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4

        solution(head);

        list1.print();
    }

}
