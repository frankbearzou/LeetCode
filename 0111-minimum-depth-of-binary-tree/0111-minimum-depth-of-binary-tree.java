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
    int depth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 0);
        return depth;
    }

    void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            depth = Math.min(depth, level + 1);
            return;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}