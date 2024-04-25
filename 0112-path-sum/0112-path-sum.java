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
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    void dfs(TreeNode root, int targetSum) {
        if (root == null)
            return;
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            if (targetSum == 0)
                res = true;
            return;
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
    }
}