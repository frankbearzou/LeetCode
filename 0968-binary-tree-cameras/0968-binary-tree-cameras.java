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
    public int minCameraCover(TreeNode root) {
        if (dfs(root) == 0)
            ans++;
        return ans;
    }

    // 0 no cover, 1 cover, 2 camera
    int dfs(TreeNode root) {
        if (root == null)
            return 1;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if (l == 1 && r == 1)
            return 0;
        if (l == 0 || r == 0) {
            ans++;
            return 2;
        }
        if (l == 2 || r == 2) {
            return 1;
        }
        return -1;
    }
}