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
    List<Integer> res = new ArrayList<>();

    public List<Integer> getLonelyNodes(TreeNode root) {
        if (root == null)
            return res;
        if (root.left != null && root.right == null)
            res.add(root.left.val);
        if (root.left == null && root.right != null)
            res.add(root.right.val);
        getLonelyNodes(root.left);
        getLonelyNodes(root.right);
        return res;
    }
}