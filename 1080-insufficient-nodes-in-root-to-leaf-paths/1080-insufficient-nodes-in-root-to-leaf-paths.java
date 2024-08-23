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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        limit -= root.val;
        if (root.left == null && root.right == null) {
            if (limit > 0)
                return null;
            return root;
        }
        if (root.left != null)
            root.left = sufficientSubset(root.left, limit);
        if (root.right != null)
            root.right = sufficientSubset(root.right, limit);
        if (root.left == null && root.right == null)
            return null;
        return root;
    }
}