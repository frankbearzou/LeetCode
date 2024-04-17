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
    public String smallestFromLeaf(TreeNode root) {
        Queue<String> queue = new PriorityQueue<>((a, b) -> b.compareTo(a));
        dfs(root, "", queue);
        return queue.peek();
    }

    void dfs(TreeNode root, String path, Queue<String> queue) {
        if (root == null)
            return;
        path = (char)('a' + root.val) + path;
        if (root.left == null && root.right == null) {
            queue.offer(path);
            if (queue.size() > 1)
                queue.poll();
            return;
        }
        dfs(root.left, path, queue);
        dfs(root.right, path, queue);
    }
}