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
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        return build(list, 0, list.size() - 1);
    }

    void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        dfs(root.left, list);
        list.add(root);
        dfs(root.right, list);
    }

    TreeNode build(List<TreeNode> list, int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode root = list.get(mid);
        root.left = build(list, start, mid - 1);
        root.right = build(list, mid + 1, end);
        return root;
    }
}