package org.facebook.LinkedLists;


import org.LinkedList;
import org.LinkedList.ListNode;
import org.junit.Test;

//https://leetcode.com/problems/middle-of-the-linked-list/
//https://javarevisited.blogspot.com/2012/12/how-to-find-middle-element-of-linked-list-one-pass.html#axzz6gbiqfayp
public class FindMiddleElement {


    //fast and slow pointer technique
    private ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode solution1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode middle = head;
        int length = 0;

        while (current != null) {
            length++;
            if (length % 2 == 0) {
                middle = middle.next;
            }
            current = current.next;
        }
        System.out.println("length of linked list " + length);
        return middle;
    }


    @Test
    public void test1() {
        LinkedList<Integer> list = new LinkedList<>();
        ListNode<Integer> head = list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);

        //System.out.println(solution(head));

        list.print(solution(head)); // 4 5 6

    }

    @Test
    public void test2() {
        LinkedList<Integer> list = new LinkedList<>();
        ListNode<Integer> head = list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        //System.out.println(solution(head));

        list.print(solution(head)); // 3 4 5

    }

}
