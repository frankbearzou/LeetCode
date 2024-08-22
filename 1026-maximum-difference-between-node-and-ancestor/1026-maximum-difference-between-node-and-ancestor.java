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
        dfs(root, root.val, root.val);
        return res;
    }

    void dfs(TreeNode root, int min, int max) {
        if (root == null)
            return;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        res = Math.max(res, Math.max(root.val - min, max - root.val));
        dfs(root.left, min, max);
        dfs(root.right, min, max);
    }
}