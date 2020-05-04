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
    private boolean ans = false;
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return s == t;
        
        if (s.val == t.val) {
            if (isEqual(s, t))
                ans = true;
        }
        isSubtree(s.left, t);
        isSubtree(s.right, t);
        
        return ans;
    }
    
    private boolean isEqual(TreeNode s, TreeNode t) {
        if (s == null || t == null)
            return s == t;
        if (s.val != t.val)
            return false;
        return isEqual(s.left, t.left) && isEqual(s.right, t.right);
    }
}
