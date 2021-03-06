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
    private int res = 0;
    private int num = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        num = k;
        dfs(root);
        return res;
    }
    
    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        num--;
        if (num == 0) {
            res = root.val;
            return;
        }
        dfs(root.right);
    }
}
