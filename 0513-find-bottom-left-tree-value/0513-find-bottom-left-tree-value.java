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
    int maxDepth = 0;
    int ans = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                ans = root.val;
            }
            return;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}