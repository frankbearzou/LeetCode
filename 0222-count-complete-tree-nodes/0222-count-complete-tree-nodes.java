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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int lCount = 0, rCount = 0;
        TreeNode l = root.left, r = root.right;
        while (l != null) {
            lCount++;
            l = l.left;
        }
        while (r != null) {
            rCount++;
            r = r.right;
        }
        if (lCount == rCount)
            return (2 << lCount) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}