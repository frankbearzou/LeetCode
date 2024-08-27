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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0)
            return null;
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == preorder[0]) {
                len = i;
                break;
            }
        }
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + len);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + len, n);
        int[] in1 = Arrays.copyOfRange(inorder, 0, len);
        int[] in2 = Arrays.copyOfRange(inorder, len + 1, n);
        TreeNode l = buildTree(pre1, in1);
        TreeNode r = buildTree(pre2, in2);
        return new TreeNode(preorder[0], l, r);
    }
}