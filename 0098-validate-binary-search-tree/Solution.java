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
    private long cur = Long.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) {
        if (root != null) {
            //cur = minValue(root);
            traverseBST(root);
        }
        return result;
    }
    
    private void traverseBST(TreeNode root) {
        if (root != null) {
            traverseBST(root.left);
            if (root.val <= cur) {
                result = false;
            } else {
                cur = root.val;
            }
            traverseBST(root.right);
        }
    }
}
