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
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            int pre = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                int val = node.val;
                if (level % 2 == 0 && val % 2 == 0)
                    return false;
                if (level % 2 == 1 && val % 2 == 1)
                    return false;
                if (i == 0) {
                    pre = val;
                } else {
                    if (level % 2 == 0) {
                        if (pre >= val)
                            return false;
                    } else {
                        if (pre <= val)
                            return false;
                    }
                    pre = val;
                }
            }
            level++;
        }
        return true;
    }
}