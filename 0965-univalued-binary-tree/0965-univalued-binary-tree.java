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
    int value;

    public boolean isUnivalTree(TreeNode root) {
        value = root.val;
        return dfs(root);
    }

    boolean dfs(TreeNode root) {
        if (root == null)
            return true;
        return root.val == value && dfs(root.left) && dfs(root.right);
    }
}