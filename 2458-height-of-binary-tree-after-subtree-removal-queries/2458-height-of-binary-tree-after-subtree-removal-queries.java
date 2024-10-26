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
    Map<TreeNode, Integer> h = new HashMap<>();
    int[] map;

    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        height(root);
        map = new int[h.size() + 1];
        dfs(root, 0, 0);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = map[queries[i]];
        }
        return ans;
    }

    int height(TreeNode root) {
        if (root == null)
            return 0;
        int l = height(root.left);
        int r = height(root.right);
        int hei = Math.max(l, r) + 1;
        h.put(root, hei);
        return hei;
    }

    void dfs(TreeNode root, int depth, int rest) {
        if (root == null)
            return;
        map[root.val] = rest;
        int r = 0;
        if (root.right != null)
            r = depth + h.getOrDefault(root.right, 0);
        dfs(root.left, depth + 1, Math.max(rest, r));
        int l = 0;
        if (root.left != null)
            l = depth + h.getOrDefault(root.left, 0);
        dfs(root.right, depth + 1, Math.max(rest, l));
    }
}