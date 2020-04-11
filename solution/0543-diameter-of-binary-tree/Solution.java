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
    private int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return max;
    }
    
    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        int longer = Math.max(left, right);
        max = Math.max(max, left + right);
        return longer + 1;
    }
}
