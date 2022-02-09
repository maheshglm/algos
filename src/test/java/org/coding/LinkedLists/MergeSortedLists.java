package org.coding.LinkedLists;

import org.LinkedList;
import org.LinkedList.ListNode;
import org.junit.Test;

//https://www.youtube.com/watch?v=KVf1Uuqfv8E
public class MergeSortedLists {


    private ListNode solution(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode temp_node = new ListNode(0);
        ListNode curr_node = temp_node;

        while (head1 != null && head2 != null) {
            if ((int) head1.data < (int) head2.data) {
                curr_node.next = head1;
                head1 = head1.next;
            } else {
                curr_node.next = head2;
                head2 = head2.next;
            }
            curr_node = curr_node.next;
        }

        if (head1 != null) {
            curr_node.next = head1;
        }

        if (head2 != null) {
            curr_node.next = head2;
        }
        return temp_node.next;
    }

    @Test
    public void test1() {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList.ListNode<Integer> head1 = list1.insert(1);
        list1.insert(2);
        list1.insert(4);

        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList.ListNode<Integer> head2 = list2.insert(1);
        list2.insert(3);
        list2.insert(4);
        list2.insert(5);

        ListNode result_node = solution(head1, head2);// 1 1 2 3 4 4

        while (result_node != null) {
            System.out.print(result_node.data + " ");
            result_node = result_node.next;
        }
    }
}
