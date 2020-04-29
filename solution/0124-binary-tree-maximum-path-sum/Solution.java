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
    private int ans = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        path(root);
        return ans;
    }
    
    private int path(TreeNode root) {
        if (root == null)
            return 0;
        int left = path(root.left);
        int right = path(root.right);
        
        int sum = Integer.MIN_VALUE, total = Integer.MIN_VALUE;
        
        sum = Math.max(sum, root.val);
        sum = Math.max(sum, left + root.val);
        sum = Math.max(sum, right + root.val);
        
        total = Math.max(sum, left + root.val + right);
        
        ans = Math.max(ans, total);
        
        return sum;
    }
}
