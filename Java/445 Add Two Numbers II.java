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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = null, node2 = null;
        int value = 0, carry = 0;

        while (l1 != null) {
            node1 = l1.next;
            l1.next = node2;
            node2 = l1;
            l1 = node1;
        }
        l1 = node2;

        node2 = null;
        while (l2 != null) {
            node1 = l2.next;
            l2.next = node2;
            node2 = l2;
            l2 = node1;
        }
        l2 = node2;

        while (l1 != null || l2 != null || carry > 0) {
            value = carry;
            
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }

            carry = value / 10;
            node1 = new ListNode(value % 10, node1);
        }
        return node1;
    }
}
