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
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        while (!cur.isEmpty()) {
            List<TreeNode> row =  new ArrayList<>(cur);
            cur = new ArrayList<>();
            int sum = 0;
            for (TreeNode node : row) {
                if (node.left != null) {
                    sum += node.left.val;
                    cur.add(node.left);
                }
                if (node.right != null) {
                    sum += node.right.val;
                    cur.add(node.right);
                }
            }
            for (TreeNode node : row) {
                int sub = (node.left != null ? node.left.val : 0) + (node.right != null ? node.right.val : 0);
                if (node.left != null)
                    node.left.val = sum - sub;
                if (node.right != null)
                    node.right.val = sum - sub;
            }
        }
        return root;
    }
}