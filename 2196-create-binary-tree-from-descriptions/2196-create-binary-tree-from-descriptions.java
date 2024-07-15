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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Integer> parent = new HashMap<>();
        for (int[] desc : descriptions) {
            parent.put(desc[1], desc[0]);
        }
        TreeNode root = new TreeNode();
        int child = descriptions[0][1];
        while (parent.get(child) != null) {
            int p = parent.get(child);
            root.val = p;
            child = p;
        }
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] desc : descriptions) {
            map.putIfAbsent(desc[0], new ArrayList());
            map.get(desc[0]).add(new int[]{desc[1], desc[2]});
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                TreeNode p = q.poll();
                List<int[]> list = map.get(p.val);
                if (list == null)
                    continue;
                for (int[] node : list) {
                    if (node[1] == 1) {
                        p.left = new TreeNode(node[0]);
                        q.offer(p.left);
                    } else {
                        p.right = new TreeNode(node[0]);
                        q.offer(p.right);
                    }
                }
            }
        }
        return root;
    }
}