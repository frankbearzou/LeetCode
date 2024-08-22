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
    int res = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root.left, root.val, root.val);
        dfs(root.right, root.val, root.val);
        return res;
    }

    void dfs(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return;
        res = Math.max(res, Math.max(root.val - min, max - root.val));
        dfs(root.left, Math.min(root.val, min), Math.max(root.val, max));
        dfs(root.right, Math.min(root.val, min), Math.max(root.val, max));
    }
}