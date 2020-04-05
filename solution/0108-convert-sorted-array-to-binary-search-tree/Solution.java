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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null)
            return null;
        TreeNode root = BST(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode BST(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BST(nums, left, mid - 1);
        root.right = BST(nums, mid + 1, right);
        return root;
    }
}
