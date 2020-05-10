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
    private int diff = Integer.MAX_VALUE;
    
    private void dfs(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return;
        
        if (min != null && root.val - min < diff)
            diff = root.val - min;
        if (max != null && max - root.val < diff)
            diff = max - root.val;
        dfs(root.left, min, root.val);
        dfs(root.right, root.val, max);
    }
    
    public int getMinimumDifference(TreeNode root) {
        dfs(root, null, null);
        return diff;
    }
}
