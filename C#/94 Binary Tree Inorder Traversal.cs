// Problem: https://leetcode.com/problems/binary-tree-inorder-traversal/

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
    public IList<int> InorderTraversal(TreeNode root) {
        var result = new List<int>();
        Rec(result, root);
        return result;
    }

    private void Rec(List<int> list, TreeNode node) {
        if (node == null) {
            return;
        }
        Rec(list, node.left);
        list.Add(node.val);
        Rec(list, node.right);
    }
}
