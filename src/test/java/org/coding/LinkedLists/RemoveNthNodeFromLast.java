package org.coding.LinkedLists;

import org.LinkedList.ListNode;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/solution/
public class RemoveNthNodeFromLast {

    /*
        We notice that the problem could be simply reduced to another one :
        Remove the (L−n+1) th node from the beginning in the list ,
        where L is the list length. This problem is easy to solve once we found list length L.
     */
    private ListNode solution(ListNode head, int n) {

        //standard steps for linked list problems
        ListNode temp = new ListNode(0);
        temp.next = head;

        //calculate length of the List first
        int len = 0;
        ListNode curr = head;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }

        //nodes to travel to delete Nth node
        //ex: [1, 2, 3, 4, 5], n = 2
        //len = 5, n = 2 and length to travel to remove last 2nd node is
        //5 - 2 = 3 nodes
        len = len - n;
        curr = temp;
        while (len > 0) {
            len--;
            curr = curr.next;
        }

        //end of this loop curr pointed to 3 above
        //3.next = 4.next i.e. 5
        //now 3.next is pointed to 5
        curr.next = curr.next.next;

        return temp.next;
    }
}
