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
    int res = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return res;
    }

    int[] dfs(TreeNode root) {
        if (root == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int x = root.val;
        if (x <= left[1] || x >= right[0])
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        int sum = x + left[2] + right[2];
        res = Math.max(res, sum);
        return new int[]{Math.min(x, left[0]), Math.max(x, right[1]), sum};
    }
}