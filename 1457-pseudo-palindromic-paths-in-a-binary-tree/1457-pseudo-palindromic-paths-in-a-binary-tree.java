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
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, "");
        return ans;
    }

    void dfs(TreeNode root, String path) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            path = path + root.val;
            int[] map = new int[10];
            for (char c : path.toCharArray()) {
                int i = c - '0';
                map[i]++;
            }
            boolean single = false;
            for (int i = 1; i < 10; i++) {
                if (map[i] % 2 == 0) {
                    continue;
                }
                if (!single) {
                    single = true;
                    continue;
                }
                return;
            }
            ans++;
            return;
        }
        dfs(root.left, path + root.val);
        dfs(root.right, path + root.val);
    }
}