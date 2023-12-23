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
    int diff = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        bst(root);
        return diff;
    }

    void bst(TreeNode root) {
        if (root == null)
            return;
        bst(root.left);
        if (pre != null) {
            diff = Math.min(diff, root.val - pre.val);
        }
        pre = root;
        bst(root.right);
    }
}