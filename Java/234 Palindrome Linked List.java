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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head.next, next, previous = null;

        while (fast != null && fast.next != null) {
            next = slow.next;
            slow.next = previous;
            previous = slow;
            slow = next;

            fast = fast.next.next;
        }

        next = slow.next;

        if (fast == null) slow = previous;
        else slow.next = previous;
        

        while (slow != null) {
            if (slow.val != next.val) return false;

            slow = slow.next;
            next = next.next;
        }

        return true;
    }
}
