package data.structure;

import Utils.ListNode;

/**
 * 141. Linked List Cycle
Easy

2601

416

Add to List

Share
Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.


Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the first node.


Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.




Follow up:

Can you solve it using O(1) (i.e. constant) memory?
 */
public class LinkedListCircle {
    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while(first != null && second  != null && second.next != null && second.next.next != null){
            first = first.next;
            second = second.next.next;
            if(first.val == second.val){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        ListNode node4 = new ListNode();

        node1.val = 3;
        node2.val = 2;
        node3.val = 0;
        node4.val = -4;

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;



        LinkedListCircle circle = new LinkedListCircle();
        boolean result = circle.hasCycle(node1);
        System.out.println(result);
    }
}
