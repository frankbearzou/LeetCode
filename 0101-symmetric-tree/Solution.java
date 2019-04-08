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
    Queue<TreeNode> queue = new LinkedList<>();
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode item = queue.remove();
                if (item != null) {
                    queue.add(item.left);
                    queue.add(item.right);
                    list.add(item.val);
                } else {
                    list.add(null);
                }
            }

            boolean isAllNull = true;
            int listSize = list.size();
            for (int i = 0; i < listSize; i++) {
                if (list.get(i) != null) {
                    isAllNull = false;
                    break;
                }
            }
            if (isAllNull)
                return true;

            for (int i = 0; i < listSize / 2; i++) {
                Integer left = list.get(i);
                Integer right = list.get(listSize - i - 1);
                if (left == null && right == null)
                    continue;
                if ((left == null && right != null) || (left != null && right == null))
                    return false;
                if (!left.equals(right))
                    return false;
            }
        }

        return true;
    }
}
