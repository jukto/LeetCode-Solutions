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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int nodeCount = 0, mod, length, effectiveLength;
        ListNode node = head, last = null;

        while (node != null) {
            node = node.next;
            nodeCount++;
        }

        mod = nodeCount % k;
        length = nodeCount / k;
        node = head;

        for (int i = 0; i < k && ((effectiveLength = (mod - i > 0) ? length + 1 : length) > 0); i++) {
            result[i] = node;
            while (effectiveLength-- > 0) {
                last = node;
                node = node.next;
            }
            last.next = null;
        }

        return result;
    }
}
