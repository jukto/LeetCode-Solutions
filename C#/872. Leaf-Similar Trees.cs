// Problem: https://leetcode.com/problems/leaf-similar-trees/

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
    public bool LeafSimilar(TreeNode root1, TreeNode root2) {
        List<int> l1 = new(), l2 = new();
        GetLeaves(root1, l1);
        GetLeaves(root2, l2);

        if (l1.Count != l2.Count) {
            return false;
        }

        for (int i = 0; i < l1.Count; i++) {
            if (l1[i] != l2[i]) {
                return false;
            }
        }

        return true;
    }

    private void GetLeaves(TreeNode node, List<int> leaves) {
        if (node == null) {
            return;
        }
        if (node.left == node.right) {
            leaves.Add(node.val);
            return;
        }

        GetLeaves(node.left, leaves);
        GetLeaves(node.right, leaves);
    }
}
