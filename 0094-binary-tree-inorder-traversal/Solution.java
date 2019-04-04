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
    
    private void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        result.add(root.val);
        inorder(root.right);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        inorder(root);
        return result;
    }
}
