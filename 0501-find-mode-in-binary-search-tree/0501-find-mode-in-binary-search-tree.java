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
    TreeNode pre = null;
    int count = 0;
    int maxCount = 0;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        bst(root);
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++)
            ans[i] = list.get(i);
        return ans;
    }

    void bst(TreeNode root) {
        if (root == null)
            return;
        bst(root.left);
        if (pre == null || root.val != pre.val) {
            count = 1;
        } else {
            count++;
        }
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(root.val);
        } else if (count == maxCount) {
            list.add(root.val);
        }
        pre = root;
        bst(root.right);
    }
}