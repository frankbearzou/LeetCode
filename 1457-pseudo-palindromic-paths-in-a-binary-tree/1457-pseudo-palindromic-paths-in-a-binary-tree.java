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
    int ans = 0;

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] map = new int[10];
        dfs(root, map);
        return ans;
    }

    void dfs(TreeNode root, int[] map) {
        if (root == null)
            return;
        map[root.val]++;
        if (root.left == null && root.right == null) {
            if (isPalindrome(map))
                ans++;
        }
        
        dfs(root.left, map);
        dfs(root.right, map);
        map[root.val]--;
    }

    boolean isPalindrome(int[] map) {
        boolean odd = false;
        for (int i = 0; i < 10; i++) {
            if (map[i] % 2 == 1) {
                if (odd)
                    return false;
                else
                    odd = true;
            }
        }
        return true;
    }
}