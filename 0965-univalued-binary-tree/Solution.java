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
    boolean result = true;
    int value = 0;
    
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)
            return true;
        value = root.val;
        traverse(root);
        return result;
    }
    
    private void traverse(TreeNode root) {
        if (root == null)
            return;
        if (root.val != value)
            result = false;
        traverse(root.left);
        traverse(root.right);
    }
}
