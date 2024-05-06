// Problem: https://leetcode.com/problems/remove-nodes-from-linked-list/

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
    public ListNode RemoveNodes(ListNode head) {
        ListNode reverse = null, result = null, node = head;
        int max = 0;

        while (node != null) {
            var tmp = node.next;
            node.next = reverse;
            reverse = node;
            node = tmp;
        }

        node = reverse;

        while (node != null) {
            if (node.val >= max) {
                max = node.val;
                var tmp = node.next;
                node.next = result;
                result = node;
                node = tmp;
            } else {
                node = node.next;
            }
        }

        return result;
    }
}
