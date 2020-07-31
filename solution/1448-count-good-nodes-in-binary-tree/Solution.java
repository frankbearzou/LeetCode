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
    private int count = 0;
    
    private void traverse(TreeNode root, int max) {
        if (root == null)
            return;
        
        int curMax = 0;
        if (root.val >= max) {
            count++;
        }
        curMax = Math.max(root.val, max);
        traverse(root.left, curMax);
        traverse(root.right, curMax);
    }
    
    public int goodNodes(TreeNode root) {
        traverse(root, Integer.MIN_VALUE);
        return count;
    }
}
