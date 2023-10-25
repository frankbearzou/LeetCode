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

    private Pair dfs(TreeNode root) {
        if (root == null) {
            return new Pair();
        }
        Pair left = dfs(root.left);
        Pair right = dfs(root.right);
        int h = Math.max(left.h, right.h) + 1;
        int d = left.h + right.h + 2;
        int maxD = Math.max(d, Math.max(left.d, right.d));
        return new Pair(h, maxD);
    }
}

class Pair {
    int h = -1; // height;
    int d; // diameter;
    public Pair() {

    }
    public Pair(int h, int d) {
        this.h = h;
        this.d = d;
    }
}