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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0)
            return null;
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == postorder[n - 1]) {
                len = i;
                break;
            }
        }
        TreeNode l = buildTree(Arrays.copyOfRange(inorder, 0, len), Arrays.copyOfRange(postorder, 0, len));
        TreeNode r = buildTree(Arrays.copyOfRange(inorder, len + 1, n), Arrays.copyOfRange(postorder, len, n - 1));
        return new TreeNode(postorder[n - 1], l, r);
    }
}