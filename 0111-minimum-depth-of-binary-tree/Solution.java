/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int level = Integer.MAX_VALUE;
    
    private void DFS(TreeNode root, int lvl) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (lvl + 1 < level) {
                level = lvl + 1;
            } 
        }
        DFS(root.left, lvl + 1);
        DFS(root.right, lvl + 1);
    }
    
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        DFS(root, 0);
        return level;
    }
}
