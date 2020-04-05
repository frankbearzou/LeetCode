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
    List<Integer> result = new ArrayList<>();
    
    private void preorder(TreeNode root) {
        if (root == null)
            return;
        result.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return result;
    }
}
