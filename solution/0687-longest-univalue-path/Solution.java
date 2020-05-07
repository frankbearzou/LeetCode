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
    private int max = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, root.val);
        return max;
    }
    
    private int dfs(TreeNode root, int val) {
        if (root == null)
            return 0;
        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        max = Math.max(max, left + right);
        if (root.val != val)
            return 0;
        return Math.max(left, right) + 1;
    }
}
