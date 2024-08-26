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

    Pair dfs(TreeNode root) {
        if (root == null)
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Pair l = dfs(root.left);
        Pair r = dfs(root.right);
        if (root.val > l.max && root.val < r.min) {
            int sum = root.val + l.sum + r.sum;
            res = Math.max(res, sum);
            return new Pair(Math.min(root.val, l.min), Math.max(root.val, r.max), sum);
        } else {
            return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }
    }
}

class Pair {
    int min;
    int max;
    int sum;
    Pair(int min, int max, int sum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}