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
    private static final List<TreeNode>[] memo = new List[10];

    public Solution() {
        memo[0] = List.of(new TreeNode());
    }

    public List<TreeNode> allPossibleFBT(int n) {
        return (n % 2 == 0) ? new ArrayList<TreeNode>() : recursion(n);
    }

    private List<TreeNode> recursion(int n) {
        if (memo[n >> 1] != null) return memo[n >> 1];

        List<TreeNode> result = new ArrayList<TreeNode>();
        int left = 1, right = n - 2;

        while (right > 0) {
            for (TreeNode leftNode : recursion(left)) {
                for (TreeNode rightNode : recursion(right)) {
                    result.add(new TreeNode(0, leftNode, rightNode));
                }
            }

            left += 2;
            right -= 2;
        }

        return memo[n >> 1] = result;
    }
}
