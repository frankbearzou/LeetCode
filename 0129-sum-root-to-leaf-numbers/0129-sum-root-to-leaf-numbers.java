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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    void dfs(TreeNode root, int val) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sum += val * 10 + root.val;
            return;
        }
        dfs(root.left, val * 10 + root.val);
        dfs(root.right, val * 10 + root.val);
    }
}