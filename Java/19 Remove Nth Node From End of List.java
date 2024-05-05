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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode superHead = new ListNode(0, head), deleteAfter = superHead, scout = superHead;

        while (n > 0) {
            scout = scout.next;
            n--;
        }

        while (scout.next != null) {
            deleteAfter = deleteAfter.next;
            scout = scout.next;
        }

        deleteAfter.next = deleteAfter.next.next;
        
        return superHead.next;
    }
}
