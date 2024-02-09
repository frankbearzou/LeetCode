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
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return build(arr, 0, arr.length - 1);
    }

    void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    TreeNode build(int[] arr, int l, int r) {
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = build(arr, l, mid - 1);
        root.right = build(arr, mid + 1, r);
        return root;
    }
}