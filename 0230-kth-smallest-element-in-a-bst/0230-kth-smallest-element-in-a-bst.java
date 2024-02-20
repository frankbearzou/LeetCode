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
    int ans = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        dfs(root);
        return ans;
    }

    void dfs(TreeNode root) {
        if (root == null || count < 0)
            return;
        dfs(root.left);
        if (--count == 0) {
            ans = root.val;
            return;
        }
        dfs(root.right);
    }
}