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
    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root, 1, 1);
    }

    int dfs(TreeNode root, int parent, int grandparent) {
        if (root == null)
            return 0;
        int val = 0;
        if (grandparent % 2 == 0) {
            val = root.val;
        }
        return val + dfs(root.left, root.val, parent) + dfs(root.right, root.val, parent);
    }
}