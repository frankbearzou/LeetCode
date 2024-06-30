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
    public TreeNode[] splitBST(TreeNode root, int target) {
        if (root == null)
            return new TreeNode[]{null, null};
        if (root.val <= target) {
            TreeNode[] node = splitBST(root.right, target);
            root.right = node[0];
            return new TreeNode[]{root, node[1]};
        } else {
            TreeNode[] node = splitBST(root.left, target);
            root.left = node[1];
            return new TreeNode[]{node[0], root};
        }
    }
}