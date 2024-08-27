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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if (n == 0)
            return null;
        if (n == 1)
            return new TreeNode(preorder[0]);
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (preorder[1] == postorder[i]) {
                len = i + 1;
                break;
            }
        }
        TreeNode l = constructFromPrePost(Arrays.copyOfRange(preorder, 1, 1 + len), Arrays.copyOfRange(postorder, 0, len + 1));
        TreeNode r = constructFromPrePost(Arrays.copyOfRange(preorder, 1 + len, n), Arrays.copyOfRange(postorder, len, n - 1));
        return new TreeNode(postorder[n - 1], l, r);
    }
}