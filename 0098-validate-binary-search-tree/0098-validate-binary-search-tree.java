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
    public boolean isValidBST(TreeNode root) {
        return postOrder(root)[1] != Long.MAX_VALUE;
    }

    long[] postOrder(TreeNode root) {
        if (root == null)
            return new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        long[] l = postOrder(root.left);
        long[] r = postOrder(root.right);
        if (root.val <= l[1] || root.val >= r[0])
            return new long[]{Long.MIN_VALUE, Long.MAX_VALUE};
        return new long[]{Math.min(l[0], root.val), Math.max(r[1], root.val)};
    }
}