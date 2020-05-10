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
    private boolean ans = true;
    
    private void dfs(TreeNode root, long min, long max) {
        if (root == null)
            return;
        
        if (root.val <= min || root.val >= max) {
            ans = false;
            return;
        }
        
        dfs(root.left, min, (long)root.val);
        dfs(root.right, (long)root.val, max);
    }
    
    public boolean isValidBST(TreeNode root) {
        dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return ans;
    }
}
