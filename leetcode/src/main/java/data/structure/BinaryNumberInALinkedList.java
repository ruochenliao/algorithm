package data.structure;

import Utils.ListNode;

import java.util.List;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 *
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * Return the decimal value of the number in the linked list.
 * Example 1:
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 *
 */
public class BinaryNumberInALinkedList {
    public int getDecimalValue(ListNode<Integer> head) {
        int sum = 0;
        while(head != null){
            sum = sum * 2;
            if(head.val == 1){
                sum++;
            }
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode<Integer> node = new ListNode<>();
        node.val = 1;
        node.next = new ListNode<>(0);
        node.next.next = new ListNode<>(0);
        BinaryNumberInALinkedList linkedList = new BinaryNumberInALinkedList();
        int result = linkedList.getDecimalValue(node);
        System.out.println(result);
    }
}
