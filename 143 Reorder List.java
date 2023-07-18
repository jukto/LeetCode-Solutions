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
    public void reorderList(ListNode head) {
        if(head.next == null) return;

        ListNode node1 = head, node2 = head.next, previous = null, current, next;

        while (node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }

        current = node1.next;
        node1.next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        node1 = head;
        node2 = previous;

        while (node2 != null) {
            next = node1.next;
            node1.next = node2;
            node1 = next;

            next = node2.next;
            node2.next = node1;
            node2 = next;
        }
    }
}
