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
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, n, inorder, 0, n);
    }

    TreeNode dfs(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR) {
        if (preL == preR)
            return null;
        int len = map.get(preorder[preL]) - inL;
        TreeNode l = dfs(preorder, preL + 1, preL + 1 + len, inorder, inL, inL + len);
        TreeNode r = dfs(preorder, preL + len + 1, preR, inorder, inL + len + 1, inR);
        return new TreeNode(preorder[preL], l, r);
    }
}