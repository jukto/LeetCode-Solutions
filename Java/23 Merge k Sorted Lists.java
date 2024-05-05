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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode superHead = new ListNode(), node = superHead;
        var queue = new PriorityQueue<ListNode>(new nodeComparator());
        for (ListNode n : lists) { if (n != null) { queue.add(n); } }

        while (!queue.isEmpty()) {
            ListNode temp = queue.poll();
            node.next = temp;
            node = temp;

            if (temp.next != null) queue.add(temp.next);
        }

        return superHead.next;
    }

    private class nodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode a, ListNode b) {
            return Integer.compare(a.val, b.val);
        }
    }
}
