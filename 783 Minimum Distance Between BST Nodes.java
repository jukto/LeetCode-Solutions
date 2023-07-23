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
    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        var list = new ArrayList<Integer>();

        inorder(list, root);

        for (int i = 0; i < list.size() - 1; i++) {
            min = Integer.min(min, list.get(i) - list.get(i + 1));
        }

        return min;
    }

    private void inorder(List<Integer> list, TreeNode node) {
        if (node == null) return;

        inorder(list, node.right);
        list.add(node.val);
        inorder(list, node.left);
    }
}
