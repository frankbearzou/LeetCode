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
    TreeNode res;
    int max = 0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    int dfs(TreeNode root, int depth) {
        if (root == null) {
            max = Math.max(max, depth);
            return depth;
        }
        int l = dfs(root.left, depth + 1);
        int r = dfs(root.right, depth + 1);
        if (max == l && max == r)
            res = root;
        return Math.max(l, r);
    }
}