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
    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
    Set<TreeNode> leafNodes = new HashSet<>();

    public int countPairs(TreeNode root, int distance) {
        int count = 0;
        dfs(root, null);
        for (TreeNode leaf : leafNodes) {
            Set<TreeNode> visited = new HashSet<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(leaf);
            for (int i = 0; i <= distance && !q.isEmpty(); i++) {
                int size = q.size();
                while (size-- > 0) {
                    TreeNode node = q.poll();
                    if (node != leaf && leafNodes.contains(node)) {
                        count++;
                    }
                    if (graph.containsKey(node)) {
                        for (TreeNode neighbor : graph.get(node)) {
                            if (visited.contains(neighbor))
                                continue;
                            visited.add(neighbor);
                            q.offer(neighbor);
                        }
                    }
                }
            }
        }
        return count / 2;
    }

    void dfs(TreeNode root, TreeNode pre) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            leafNodes.add(root);
        }
        if (pre != null) {
            graph.putIfAbsent(pre, new ArrayList());
            graph.get(pre).add(root);
            graph.putIfAbsent(root, new ArrayList());
            graph.get(root).add(pre);
        }
        dfs(root.left, root);
        dfs(root.right, root);
    }
}