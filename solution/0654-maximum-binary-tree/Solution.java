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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
    
    private TreeNode construct(int[] nums, int begin, int end) {
        if (begin > end)
            return null;
        int index = max(nums, begin, end);
        TreeNode node = new TreeNode(nums[index]);
        node.left = construct(nums, begin, index - 1);
        node.right = construct(nums, index + 1, end);
        return node;
    }
    
    private int max(int[] nums, int begin, int end) {
        int index = begin;
        for (int i = begin + 1; i <= end; i++) {
            if (nums[i] > nums[index])
                index = i;
        }
        return index;
    }
}
