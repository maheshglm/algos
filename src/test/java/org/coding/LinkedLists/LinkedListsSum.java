package org.coding.LinkedLists;

import org.LinkedList;
import org.LinkedList.ListNode;
import org.junit.Test;

//https://www.youtube.com/watch?v=TXsGUEmVNQk&list=PL5b07qlmA3P6UWAVm6rnJXpWAB3Vnj59B&index=36
//https://www.youtube.com/watch?v=aM4Iv7eEr2o&t=271s
public class LinkedListsSum {

    private ListNode solution(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        int sum;
        int carry = 0;
        while (l1 != null || l2 != null) {

            int v1 = getVal(l1);
            int v2 = getVal(l2);

            sum = carry + v1 + v2;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) {
            curr.next = new ListNode<>(carry);
        }
        return dummy.next;
    }

    private int getVal(ListNode node) {
        return node != null ? (int) node.data : 0;
    }

    @Test
    public void test1() {
        LinkedList<Integer> list1 = new LinkedList<>();
        ListNode<Integer> head1 = list1.insert(2);
        list1.insert(4);
        list1.insert(3);

        LinkedList<Integer> list2 = new LinkedList<>();
        ListNode<Integer> head2 = list2.insert(5);
        list2.insert(6);
        list2.insert(4);

        ListNode solution = solution(head1, head2);

        //Output = 708
        while (solution != null) {
            System.out.print(solution.data + "");
            solution = solution.next;
        }
        System.out.println();
    }

    @Test
    public void test2() {
        LinkedList<Integer> list1 = new LinkedList<>();
        ListNode<Integer> head1 = list1.insert(0);

        LinkedList<Integer> list2 = new LinkedList<>();
        ListNode<Integer> head2 = list2.insert(0);

        ListNode solution = solution(head1, head2);

        //Output = 0
        while (solution != null) {
            System.out.print(solution.data + "");
            solution = solution.next;
        }
        System.out.println();
    }

    @Test
    public void test3() {
        LinkedList<Integer> list1 = new LinkedList<>();
        ListNode<Integer> head1 = list1.insert(9);
        list1.insert(9);
        list1.insert(9);
        list1.insert(9);
        list1.insert(9);
        list1.insert(9);
        list1.insert(9);

        LinkedList<Integer> list2 = new LinkedList<>();

        ListNode<Integer> head2 = list2.insert(9);
        list2.insert(9);
        list2.insert(9);
        list2.insert(9);

        ListNode solution = solution(head1, head2);

        //Output = 89990001
        while (solution != null) {
            System.out.print(solution.data + "");
            solution = solution.next;
        }
        System.out.println();
    }
}
