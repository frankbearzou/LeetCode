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
    private List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum, new ArrayList<Integer>());
        return ans;
    }
    
    private void dfs(TreeNode root, int sub, int sum, List<Integer> list) {
        if (root == null)
            return;
        
        list.add(root.val);
        if (root.left == null && root.right == null && root.val + sub == sum) {
            ans.add(new ArrayList<>(list));
        }
        
        dfs(root.left, sub + root.val, sum, list);
        dfs(root.right, sub + root.val, sum, list);
        list.remove(list.size() - 1);
    }
}
