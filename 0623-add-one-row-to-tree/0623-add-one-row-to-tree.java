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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int d = 1;
        while (d + 1 <= depth) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (d + 1 == depth) {
                    node.left = new TreeNode(val, left, null);
                    node.right = new TreeNode(val, null, right);
                } else {
                    if (left != null)
                        queue.offer(left);
                    if (right != null)
                        queue.offer(right);
                }
            }
            if (d + 1 == depth)
                return root;
            d++;
        }
        return root;
    }
}