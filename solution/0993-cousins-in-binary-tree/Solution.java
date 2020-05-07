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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y)
            return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            boolean containsOne = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && node.right != null) {
                    int l = node.left.val;
                    int r = node.right.val;
                    if ((l == x && r == y) || (l == y && r == x))
                        return false;
                }
                if (node.left != null) {
                    int l = node.left.val;
                    if (l == x || l == y) {
                        if (containsOne)
                            return true;
                        else
                            containsOne = true;
                    }
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    int r = node.right.val;
                    if (r == x || r == y) {
                        if (containsOne)
                            return true;
                        else
                            containsOne = true;
                    }
                    queue.offer(node.right);
                }
            }
        }
        
        return false;
    }
}
