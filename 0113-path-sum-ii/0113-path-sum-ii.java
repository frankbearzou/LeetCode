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
        List<Integer> list = new ArrayList<>();
        dfs(root, targetSum, list, ans);
        return ans;
    }

    void dfs(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> ans) {
        if (root == null)
            return;
        list.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left, targetSum - root.val, list, ans);
        dfs(root.right, targetSum - root.val, list, ans);
        list.remove(list.size() - 1);
    }
}