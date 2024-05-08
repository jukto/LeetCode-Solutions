// Problem: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

public class Solution {
    public TreeNode GetTargetCopy(TreeNode original, TreeNode cloned, TreeNode target) {
        return DFS(cloned, target.val);
        //return FollowUp(original, cloned, target);
    }

    private TreeNode DFS(TreeNode node, int target) {
        if (node == null) return null;
        if (node.val == target) return node;

        return DFS(node.left, target) ?? DFS(node.right, target);
    }

    // Solution for the Follow up prompt.
    private TreeNode FollowUp(TreeNode origin, TreeNode clone, TreeNode target) {
        if (origin == null) return null;
        if (origin == target) return clone;

        return FollowUp(origin.left, clone.left, target) ?? FollowUp(origin.right, clone.right, target);
    }
}
