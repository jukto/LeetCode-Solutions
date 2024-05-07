// Problem: https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode DoubleIt(ListNode head) {
        ListNode node = head;
        
        if (node.val > 4) {
            head = new ListNode(1, node);
        }

        while (node.next != null) {
            node.val = (node.val * 2 + (node.next.val > 4 ? 1 : 0)) % 10;
            node = node.next;
        }

        node.val = (node.val * 2) % 10;

        return head;
    }
}
