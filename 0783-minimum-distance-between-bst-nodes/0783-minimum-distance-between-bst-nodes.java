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
    int pre = -100001;
    int diff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return diff;
    }

    void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.left);
        if (root.val - pre < diff) {
            diff = root.val - pre;
        }
        pre = root.val;
        dfs(root.right);
    }
}