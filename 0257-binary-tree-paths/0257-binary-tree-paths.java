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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null)
            return ans;
        List<String> list = new ArrayList<>();
        path(root, list, ans);
        return ans;
    }

    void path(TreeNode root, List<String> list, List<String> ans) {
        list.add("" + root.val);
        if (root.left == null && root.right == null) {
            String s = "";
            for (int i = 0; i < list.size() - 1; i++) {
                s += list.get(i) + "->";
            }
            s += list.get(list.size() - 1);
            ans.add(s);
            return;
        }
        if (root.left != null) {
            path(root.left, list, ans);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            path(root.right, list, ans);
            list.remove(list.size() - 1);
        }
    }
}