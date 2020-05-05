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
    private int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
    
    private void dfs(TreeNode root, int sub) {
        if (root == null)
            return;
        
        if (root.left == null && root.right == null) {
            sum += sub * 10 + root.val;
        }
        dfs(root.left, sub * 10 + root.val);
        dfs(root.right, sub * 10 + root.val);
    }
}
