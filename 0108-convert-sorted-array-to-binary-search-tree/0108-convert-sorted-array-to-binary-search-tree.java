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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        int n = nums.length;
        int mid = n / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (mid > 0)
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
        if (mid < n - 1)
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, n));
        return root;
    }
}