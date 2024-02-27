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
    public int diameterOfBinaryTree(TreeNode root) {
        return dfs(root).d;
    }

    Pair dfs(TreeNode root) {
        if (root == null)
            return new Pair(-1, -1);
        Pair l = dfs(root.left);
        Pair r = dfs(root.right);
        int h = Math.max(l.h, r.h) + 1;
        int d = Math.max(l.h + r.h + 2, Math.max(l.d, r.d));
        return new Pair(h, d);
    }
}

class Pair {
    int h;
    int d;
    Pair(int height, int diameter) {
        h = height;
        d = diameter;
    }
}