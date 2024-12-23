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
    public int minimumOperations(TreeNode root) {
        int count = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] row = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                row[i] = node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            int[] sorted = Arrays.copyOf(row, size);
            Arrays.sort(sorted);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                map.put(sorted[i], i);
            }
            int index = 0;
            while (index < size) {
                int other = map.get(row[index]);
                if (index != other) {
                    int tmp = row[index];
                    row[index] = row[other];
                    row[other] = tmp;
                    count++;
                } else {
                    index++;
                }
            }
        }
        return count;
    }
}