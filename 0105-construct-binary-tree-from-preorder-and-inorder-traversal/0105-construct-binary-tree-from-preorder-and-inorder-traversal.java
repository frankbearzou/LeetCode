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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    TreeNode buildTree(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, Map<Integer, Integer> map) {
        if (preL > preR || inL > inR)
            return null;
        TreeNode root = new TreeNode(preorder[preL]);
        int mid = map.get(preorder[preL]);
        int leftLen = mid - inL;
        root.left = buildTree(preorder, preL + 1, preL + leftLen, inorder, inL, mid - 1, map);
        root.right = buildTree(preorder, preL + leftLen + 1, preR, inorder, mid + 1, inR, map);
        return root;
    }
}