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
    public TreeNode pruneTree(TreeNode root) {
        prune(root);
        return root;
    }
    
    private boolean prune(TreeNode root) {
        if (root == null)
            return true;
        
        if (prune(root.left))
            root.left = null;
        if (prune(root.right))
            root.right = null;
        
        return root.val == 0 && root.left == null && root.right == null;
    }
}
