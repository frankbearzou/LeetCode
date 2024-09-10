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
    String res;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return res;
    }

    void dfs(TreeNode root, String path) {
        if (root == null)
            return;
        String cur = (char)('a' + root.val) + path;
        if (root.left == null && root.right == null) {
            if (res == null) {
                res = cur;
            } else if (cur.compareTo(res) < 0) {
                res = cur;
            }
            return;
        }
        dfs(root.left, (char)('a' + root.val) + path);
        dfs(root.right, (char)('a' + root.val) + path);
    }
}