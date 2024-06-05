// Problem: https://leetcode.com/problems/range-sum-of-bst/

/**
 * Definition for a binary tree root.
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
    public int RangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        var result = (root.val >= low && root.val <= high) ? root.val : 0;

        if (root.val > low) {
            result += RangeSumBST(root.left, low, high);
        }

        if (root.val < high) {
            result += RangeSumBST(root.right, low, high);
        }

        return result;
    }
}
