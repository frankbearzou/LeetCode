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
    private int ans = 0;
    
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        dfs(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return ans;
    }
    
    private void dfs(TreeNode root, int sum) {
        if (root == null)
            return;
        if (sum - root.val == 0)
            ans++;
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }
}
