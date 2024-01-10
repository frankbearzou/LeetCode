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
    Map<Integer, List<Integer>> createGraph(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                map.putIfAbsent(node.val, new ArrayList());
                if (node.left != null) {
                    queue.offer(node.left);
                    map.get(node.val).add(node.left.val);
                    map.putIfAbsent(node.left.val, new ArrayList());
                    map.get(node.left.val).add(node.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    map.get(node.val).add(node.right.val);
                    map.putIfAbsent(node.right.val, new ArrayList());
                    map.get(node.right.val).add(node.val);
                }
            }
        }
        return map;
    }
    public int amountOfTime(TreeNode root, int start) {
        int count = -1;
        Map<Integer, List<Integer>> map = createGraph(root);System.out.println(map);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);System.out.println("v1"+visited);if (visited.contains(3))System.out.println(3);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                List<Integer> neighbours = map.get(queue.poll());System.out.println("neis:"+neighbours+" "+count);
                for (int nei : neighbours) {
                    if (!visited.contains(nei)) {
                        visited.add(nei);
                        queue.offer(nei);
                    }
                }
            }
            count++;
        }
        return count;
    }
}