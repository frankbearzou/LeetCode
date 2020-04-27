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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        
        int left = t1 != null ? t1.val : 0;
        int right = t2 != null ? t2.val : 0;
        TreeNode node = new TreeNode(left + right);
        
        node.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        node.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
        
        return node;
    }
}
