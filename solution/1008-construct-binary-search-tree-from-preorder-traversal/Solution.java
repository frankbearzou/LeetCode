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
    private int i;
    public TreeNode bstFromPreorder(int[] preorder) {
        return createBst(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode createBst(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound)
            return null;
        TreeNode node = new TreeNode(preorder[i++]);
        node.left = createBst(preorder, node.val);
        node.right = createBst(preorder, bound);
        return node;
    }
}
