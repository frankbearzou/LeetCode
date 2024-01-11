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
    int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return max;
    }

    void dfs(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            dfs(root, root.left);
        if (root.right != null)
            dfs(root, root.right);
        dfs(root.left);
        dfs(root.right);
    }

    void dfs(TreeNode a, TreeNode b) {
        if (b == null)
            return;
        max = Math.max(max, Math.abs(a.val - b.val));
        dfs(a, b.left);
        dfs(a, b.right);
    }
}