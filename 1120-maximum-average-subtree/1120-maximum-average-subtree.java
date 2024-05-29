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
    double res = 0.0;

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    int[] dfs(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        res = Math.max(res, 1.0 * (l[0] + r[0] + root.val) / (l[1] + r[1] + 1));
        return new int[]{l[0] + r[0] + root.val, l[1] + r[1] + 1};
    }
}

