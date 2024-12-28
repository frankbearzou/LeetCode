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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int pre = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (level % 2 == 0) {
                    if (node.val % 2 == 0)
                        return false;
                } else {
                    if (node.val % 2 == 1)
                        return false;
                }
                if (i == 0) {
                    pre = node.val;
                } else {
                    if (level % 2 == 0) {
                        if (pre >= node.val)
                            return false;
                    } else {
                        if (pre <= node.val)
                            return false;
                    }
                }
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
        }
        return true;
    }
}