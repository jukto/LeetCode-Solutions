// Problem: https://leetcode.com/problems/construct-string-from-binary-tree/

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
    public string Tree2str(TreeNode root) {
        var sb = new StringBuilder();
        DFS(sb, root);
        return sb.ToString();
    }

    private void DFS(StringBuilder sb, TreeNode node) {
        sb.Append(node.val);

        if (node.left != null) {
            sb.Append('(');
            DFS(sb, node.left);
            sb.Append(')');
        } else if (node.right != null) {
            sb.Append("()");
        }

        if (node.right != null) {
            sb.Append('(');
            DFS(sb, node.right);
            sb.Append(')');
        }
    }
}
