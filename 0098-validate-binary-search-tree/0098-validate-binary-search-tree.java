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
    Integer prev = null;
    boolean valid = true;

    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return valid;
    }

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev == null) {
            prev = root.val;
        } else {
            if (root.val <= prev) {
                valid = false;
                return;
            }
            prev = root.val;
        }
        inorder(root.right);
    }
}