/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        var queue = new LinkedList<TreeNode>();
        var nodeDepth = new HashMap<TreeNode, Integer>();

        queue.add(root);
        nodeDepth.put(root, 0);

        while (true) {
            TreeNode node = queue.remove(), left = node.left, right = node.right;
            int depth = nodeDepth.get(node) + 1;
            if (left == right) return depth;
            if (left != null) {
                nodeDepth.put(left, depth);
                queue.add(left);
            }
            if (right != null) {
                nodeDepth.put(right, depth);
                queue.add(right);
            }
        }
    }
}
