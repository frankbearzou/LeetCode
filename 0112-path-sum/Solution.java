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
    private int sum;
    private boolean result = false;
    
    private void topDown(TreeNode root, int val) {
        if (root == null)
            return;
        
        if (root.left == null && root.right == null) {
            if (val + root.val == sum) {
                result = true;
                return;
            }
        }
        
        topDown(root.left, root.val + val);
        topDown(root.right, root.val + val);
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        this.sum = sum;
        topDown(root, 0);
        return result;
    }
}
