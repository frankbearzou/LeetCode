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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length;i ++)
            arr[i] = list.get(i);
        int n = arr.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int query : queries) {
            int i = lowerBound(arr, query);
            int max = i == n ? -1 : arr[i];
            if (i == n || arr[i] != query)
                i--;
            int min = i < 0 ? -1 : arr[i];
            res.add(List.of(min, max));
        }
        return res;
    }

    void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

    int lowerBound(int[] arr, int query) {
        int l = 0, n = arr.length, r = n - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] == query)
                return m;
            else if (arr[m] < query)
                l = m + 1;
            else
                r = m - 1;
        }
        return l;
    }
}