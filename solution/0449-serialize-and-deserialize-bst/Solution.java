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
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty())
            return null;
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode deserialize(LinkedList<String> queue, int min, int max) {
        if (queue.isEmpty())
            return null;
        String s = queue.peek();
        int val = Integer.valueOf(s);
        if (val < min || val > max)
            return null;
        queue.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(queue, min, val);
        root.right = deserialize(queue, val, max);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
