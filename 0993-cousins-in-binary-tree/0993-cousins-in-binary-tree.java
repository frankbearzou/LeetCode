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
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundx = false, foundy = false;
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.val == x)
                        foundx = true;
                    else if (node.left.val == y)
                        foundy = true;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == x)
                        foundx = true;
                    else if (node.right.val == y)
                        foundy = true;
                }
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x || node.left.val == y) && (node.right.val == x || node.right.val == y))
                        return false;
                }
            }
            if (foundx && foundy)
                return true;
        }
        return false;
    }
}

