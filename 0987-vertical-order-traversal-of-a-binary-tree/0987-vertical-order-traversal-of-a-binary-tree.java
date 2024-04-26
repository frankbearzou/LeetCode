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
    Map<Integer, List<int[]>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (var values : map.values()) {
            Collections.sort(values, (a, b) -> {
                if (a[1] != b[1])
                    return a[1] - b[1];
                return a[0] - b[0];
            });
            List<Integer> list = new ArrayList<>();
            for (int[] arr : values)
                list.add(arr[0]);
            res.add(list);
        }
        return res;
    }

    void dfs(TreeNode root, int row, int column) {
        if (root == null)
            return;
        map.putIfAbsent(column, new ArrayList<>());
        map.get(column).add(new int[]{root.val, row, column});
        dfs(root.left, row + 1, column - 1);
        dfs(root.right, row + 1, column + 1);
    }
}