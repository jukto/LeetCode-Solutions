/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        var result = new ArrayList<Integer>();
        var parentMap = new HashMap<TreeNode, TreeNode>();
        var queue = new LinkedList<TreeNode>();

        parentMap.put(root, null);
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                parentMap.put(node.left, node);
                queue.add(node.left);
            }
            if (node.right != null) {
                parentMap.put(node.right, node);
                queue.add(node.right);
            }
        }

        queue.add(target);

        while (!queue.isEmpty() && k > 0) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.remove();

                if (parentMap.containsKey(node.left)) queue.add(node.left);
                if (parentMap.containsKey(node.right)) queue.add(node.right);

                var parent = parentMap.remove(node);
                if (parentMap.containsKey(parent)) queue.add(parent);
            }
            k--;
        }

        for (TreeNode node : queue) { result.add(node.val); }

        return result;
    }
}
