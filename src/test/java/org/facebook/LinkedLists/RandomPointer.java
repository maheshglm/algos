package org.facebook.LinkedLists;

import org.LinkedList.ListNode;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=Py6tPf74Kyc
//https://www.youtube.com/watch?v=nlKGb5cvvmU
//https://leetcode.com/problems/copy-list-with-random-pointer/
public class RandomPointer {


    private ListNode solution(ListNode head) {
        if (head == null) {
            return null;
        }

        Map<ListNode, ListNode> map = new HashMap<>();

        ListNode curr = head;
        while (curr != null) {
            map.put(curr, new ListNode(curr.data));
            curr = curr.next;
        }
        curr = head;

        while (curr != null) {
            if (curr.next != null) {
                map.get(curr).next = map.get(curr.next);
            } else {
                map.get(curr).next = null;
            }

            //since random is not part of our ListNode DS, I have commented
//            if(curr.random != null){
//                map.get(curr).random = map.get(curr.random);
//            } else {
//                map.get(curr).random = null;
//            }
            curr = curr.next;
        }

        return map.get(head);
    }

}
