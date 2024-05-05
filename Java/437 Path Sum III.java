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

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> sumFreq = new HashMap<Long, Integer>();
        sumFreq.put(0l, 1);

        return recursion(root, targetSum, sumFreq, 0);
    }

    private int recursion(TreeNode node, int targetSum, HashMap<Long, Integer> sumFreq, long runningSum) {
        if (node == null) return 0;

        runningSum += node.val;

        int currentFreq = sumFreq.getOrDefault(runningSum, 0);
        int result = sumFreq.getOrDefault(runningSum - targetSum, 0);

        sumFreq.put(runningSum, currentFreq + 1);

        result += recursion(node.left, targetSum, sumFreq, runningSum) + recursion(node.right, targetSum, sumFreq, runningSum);

        sumFreq.replace(runningSum, currentFreq);

        return result;
    }
}
