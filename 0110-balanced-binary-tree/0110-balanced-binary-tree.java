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
    public boolean isBalanced(TreeNode root) {
        Pair p = dfs(root);
        return p.b;
    }

    Pair dfs(TreeNode root) {
        if (root == null)
            return new Pair(0, true);
        Pair l = dfs(root.left);
        Pair r = dfs(root.right);
        int h = Math.max(l.h, r.h) + 1;
        boolean b = l.b && r.b && (Math.abs(l.h - r.h) <= 1);
        return new Pair(h, b);
    }
}

class Pair {
    int h;
    boolean b;
    Pair(int h, boolean b) {
        this.h = h;
        this.b = b;
    }
}