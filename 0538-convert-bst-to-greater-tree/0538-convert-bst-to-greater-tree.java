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
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        bst(root, list);
        map.put(list.get(list.size() - 1), list.get(list.size() - 1));
        for (int i = list.size() - 2; i >= 0; i--) {
            map.put(list.get(i), list.get(i) + map.get(list.get(i + 1)));
        }
        return bst(root, map);
    }

    void bst(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        bst(root.left, list);
        list.add(root.val);
        bst(root.right, list);
    }

    TreeNode bst(TreeNode root, Map<Integer, Integer> map) {
        if (root == null)
            return root;
        root.val = map.get(root.val);
        root.left = bst(root.left, map);
        root.right = bst(root.right, map);
        return root;
    }
}