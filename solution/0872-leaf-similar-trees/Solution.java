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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeaf(root1);
        List<Integer> list2 = getLeaf(root2);
        return list1.equals(list2);
    }
    
    private List<Integer> getLeaf(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }
    
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            list.add(root.val);
        else {
            traverse(root.left, list);
            traverse(root.right, list);
        }
    }
}
