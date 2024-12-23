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
    public TreeNode reverseOddLevels(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int depth = 0;
        while (!list.isEmpty()) {
            if (depth % 2 == 1) {
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int tmp = list.get(l).val;
                    list.get(l).val = list.get(r).val;
                    list.get(r).val = tmp;
                    l++;
                    r--;
                }
            }
            List<TreeNode> next = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).left != null)
                    next.add(list.get(i).left);
                if (list.get(i).right != null)
                    next.add(list.get(i).right);
            }
            list = next;
            depth++;
        }
        return root;
    }
}