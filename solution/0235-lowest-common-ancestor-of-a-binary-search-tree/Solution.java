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
    private TreeNode ans = null;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        dfs(root, min, max);
        return ans;
    }
    
    private void dfs(TreeNode root, int min, int max) {
        if (root == null)
            return;
        
        if (root.val >= min && root.val <= max)
            ans = root;
        else if (root.val > max)
            dfs(root.left, min, max);
        else if (root.val < min)
            dfs(root.right, min, max);
    }
}
