/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder ans = new StringBuilder("[");
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
        }

        while (!queue.isEmpty()) {
            if (queue.stream().allMatch(node -> node == null))
                break;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null)
                    ans.append(",null");
                else {
                    ans.append("," + node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }

        if (ans.length() > 1 && ans.charAt(1) == ',')
            ans.deleteCharAt(1);
        ans.append(']');
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 2)
            return null;

        LinkedList<TreeNode> queue = new LinkedList<>();
        String[] split = data.substring(1, data.length() - 1).split(",");
        int pos = 1;
        TreeNode root = new TreeNode(Integer.valueOf(split[0]));
        queue.offer(root);
        while (pos < split.length) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                TreeNode node = queue.poll();
                if ("null".equals(split[pos])) {
                    node.left = null;
                } else {
                    node.left = new TreeNode(Integer.valueOf(split[pos]));
                    queue.offer(node.left);
                }
                pos++;

                if (pos < split.length) {
                    if ("null".equals(split[pos])) {
                        node.right = null;
                    } else {
                        node.right = new TreeNode(Integer.valueOf(split[pos]));
                        queue.offer(node.right);
                    }
                }
                pos++;
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
