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
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (map.containsKey(root))
            return map.get(root);
        int yes = root.val;
        if (root.left != null) {
            yes += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            yes += rob(root.right.left) + rob(root.right.right);
        }
        int no = rob(root.left) + rob(root.right);
        map.put(root, Math.max(yes, no));
        return Math.max(yes, no);
    }
}