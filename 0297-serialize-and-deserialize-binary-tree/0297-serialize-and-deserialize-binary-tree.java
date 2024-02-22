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
        List<String> list = new ArrayList<>();
        dfs(root, list);
        return String.join(",", list);
    }

    void dfs(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("null");
            return;
        }
        list.add(String.valueOf(root.val));
        dfs(root.left, list);
        dfs(root.right, list);
    }

    int index = 0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        index = 0;
        return dfs(split);
    }

    TreeNode dfs(String[] split) {
        if (index >= split.length)
            return null;
        TreeNode root = null;
        String node = split[index++];
        if (!"null".equals(node)) {
            root = new TreeNode(Integer.parseInt(node));
            root.left = dfs(split);
            root.right = dfs(split);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));