// Problem: https://leetcode.com/problems/delete-leaves-with-a-given-value/

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
    public TreeNode RemoveLeafNodes(TreeNode root, int target) {
        Rec(root, target);
        return (root.val == target && IsLeaf(root)) ? null : root;
    }

    private void Rec(TreeNode node, int target) {
        if (node.left != null) {
            Rec(node.left, target);
            if (node.left.val == target && IsLeaf(node.left)) {
                node.left = null;
            }
        }

        if (node.right != null) {
            Rec(node.right, target);
            if (node.right.val == target && IsLeaf(node.right)) {
                node.right = null;
            }
        }
    }

    private static bool IsLeaf(TreeNode node) => node.left == node.right;
}
