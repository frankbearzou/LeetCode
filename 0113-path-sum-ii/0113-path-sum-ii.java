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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, ans, path, targetSum);
        return ans;
    }

    void dfs(TreeNode root, List<List<Integer>> ans, List<Integer> path, int targetSum) {
        if (root == null)
            return;
        path.add(root.val);
        if (targetSum - root.val == 0 && root.left == null && root.right == null) {
            ans.add(new ArrayList(path));
        }
        dfs(root.left, ans, path, targetSum - root.val);
        dfs(root.right, ans, path, targetSum - root.val);
        path.remove(path.size() - 1);
    }
}