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
    TreeNode result = null;
    
    private boolean DFS(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return false;
        int left = DFS(root.left, p, q) ? 1 : 0;
        int right = DFS(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid > 1)
            result = root;
        return left + right + mid > 0;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        DFS(root, p, q);
        return result;
    }
}
