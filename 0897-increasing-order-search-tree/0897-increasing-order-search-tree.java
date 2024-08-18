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
    TreeNode head = null, h = null;

    public TreeNode increasingBST(TreeNode root) {
        if (root == null)
            return null;
        increasingBST(root.left);
        if (head == null) {
            head = new TreeNode(root.val);
            h = head;
        } else {
            h.right = new TreeNode(root.val);
            h = h.right;
        }
        increasingBST(root.right);
        return head;
    }
}