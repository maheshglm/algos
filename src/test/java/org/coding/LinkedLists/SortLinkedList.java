package org.coding.LinkedLists;


import org.LinkedList;
import org.LinkedList.ListNode;
import org.junit.Test;

//https://www.youtube.com/watch?v=pNTc1bM1z-4
public class SortLinkedList {


    private ListNode<Integer> solution(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        //by this, slow ll pointed to mid. temp will be pointed to end node of 1st half
        //head will be start of 1st half, fast will be end of 2nd half;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //Now break the connection between 1st and 2nd half
        temp.next = null;

        //recurs the solution as we are using merge sort
        ListNode left_side = solution(head);
        ListNode right_side = solution(slow);

        return merge(left_side, right_side);
    }

    public ListNode merge(ListNode<Integer> l1, ListNode<Integer> l2) {

        ListNode<Integer> sorted_temp = new ListNode(0);
        ListNode<Integer> curr_node = sorted_temp;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                curr_node.next = l1;
                l1 = l1.next;
            } else {
                curr_node.next = l2;
                l2 = l2.next;
            }
            curr_node = curr_node.next;
        }

        if (l1 != null) {
            curr_node.next = l1;
        } else {
            curr_node.next = l2;
        }

        return sorted_temp.next;
    }


    @Test
    public void test1() {
        LinkedList<Integer> list1 = new LinkedList<>();
        ListNode<Integer> head = list1.insert(5);
        list1.insert(4);
        list1.insert(3);
        list1.insert(2);
        list1.insert(1);

        list1.print();

        //Output = 1 2 3 4 5

        ListNode<Integer> newHead = solution(head);

        list1.print(newHead);

    }
}
