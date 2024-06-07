// Problem: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    private int diff = 0;

    public int MaxAncestorDiff(TreeNode root) {
        DFS(root, root.val, root.val);
        return diff;
    }

    private void DFS(TreeNode node, int min, int max) {
        if (node == null) return;

        diff = Math.Max(diff, Math.Max(Math.Abs(min - node.val), Math.Abs(max - node.val)));

        min = Math.Min(min, node.val);
        max = Math.Max(max, node.val);

        DFS(node.left, min, max);
        DFS(node.right, min, max);
    }
}
