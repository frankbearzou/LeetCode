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
        return height(root).b;
    }

    private Pair height(TreeNode root) {
        if (root == null) {
            return new Pair(0, true);
        }
        Pair l = height(root.left);
        Pair r = height(root.right);
        int h = Math.max(l.h, r.h) + 1;
        boolean b = l.b && r.b && Math.abs(l.h - r.h) <= 1;
        return new Pair(h, b);
    }
}

class Pair {
    int h;
    boolean b;
    public Pair(int h, boolean b) {
        this.h = h;
        this.b = b;
    }
}