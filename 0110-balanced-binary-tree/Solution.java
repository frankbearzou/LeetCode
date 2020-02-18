/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean result = true;
    
    public boolean isBalanced(TreeNode root) {
        traverse(root);
        return result;
    }
    
    private int traverse(TreeNode root) {
        if (root == null)
            return -1;
        int left = traverse(root.left);
        int right = traverse(root.right);
        if (Math.abs(left - right) > 1)
            result = false;
        return Math.max(left, right) + 1;
    }
}
