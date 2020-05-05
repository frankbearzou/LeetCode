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
    private List<String> ans = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new ArrayList<Integer>());
        return ans;
    }
    
    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        
        list.add(root.val);
        if (root.left == null && root.right == null) {
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                str += list.get(i);
                if (i != list.size() - 1)
                    str += "->";
            }
            ans.add(str);
        }
        
        dfs(root.left, list);
        dfs(root.right, list);
        list.remove(list.size() - 1);
    }
}
