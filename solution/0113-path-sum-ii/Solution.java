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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, "", sum, ans);
        return ans;
    }
    
    private void dfs(TreeNode root, int sub, String str, int sum, List<List<Integer>> ans) {
        if (root == null)
            return;
        
        if (root.left == null && root.right == null && root.val + sub == sum) {
            String[] split = str.split(",");
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < split.length; i++) {
                if (split[i] != null && split[i].length() > 0)
                    list.add(Integer.valueOf(split[i]));
            }
            list.add(root.val);
            ans.add(list);
        }
        
        dfs(root.left, sub + root.val, str + "," + root.val, sum, ans);
        dfs(root.right, sub + root.val, str + "," + root.val, sum, ans);
    }
}
