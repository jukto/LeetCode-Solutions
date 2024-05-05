//  Problem: https://leetcode.com/problems/partition-list

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        // Let list 'left' represent a linked list of Nodes less than x, and 'right' will be the rest.
        ListNode leftHead = new ListNode(), leftTail = leftHead, rightHead = new ListNode(0, head),
            node = rightHead, previous = rightHead;

        // For each node, if it is less than x, remove it from right and add it to left.
        while ((node = node.next) != null) {
            if (node.val < x) {
                leftTail.next = leftTail = node;
                previous.next = node.next;
            } else {
                previous = node;
            }
        }

        // Attach right to the end of left and return the result.
        leftTail.next = rightHead.next;
        return leftHead.next;
    }
}
