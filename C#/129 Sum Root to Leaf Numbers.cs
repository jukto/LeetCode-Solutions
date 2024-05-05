// Problem: https://leetcode.com/problems/sum-root-to-leaf-numbers/

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
    public int SumNumbers(TreeNode root) {
        return DFS(root, 0);
    }

    private int DFS(TreeNode node, int running) {
        running = running * 10 + node.val;

        if (node.left == null && node.right == null) {
            return running;
        }

        int result = 0;
        if (node.left != null) {
            result += DFS(node.left, running);
        }
        if (node.right != null) {
            result += DFS(node.right, running);
        }
        return result;
    }
}
