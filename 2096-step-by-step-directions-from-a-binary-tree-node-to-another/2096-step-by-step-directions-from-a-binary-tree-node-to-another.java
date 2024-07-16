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
    Map<Integer, TreeNode> parent = new HashMap<>();
    Map<Integer, Integer> height = new HashMap<>();

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder back = new StringBuilder();
        dfs(root, null, 0);
        TreeNode lca = findLCA(startValue, destValue);
        int start = height.get(startValue) - height.get(lca.val);
        while (start-- > 0) {
            back.append("U");
        }
        StringBuilder dest = new StringBuilder();
        build(lca, dest, destValue);
        return back.toString() + dest.reverse().toString();
    }

    void dfs(TreeNode root, TreeNode p, int h) {
        if (root == null)
            return;
        parent.put(root.val, p);
        height.put(root.val, h);
        dfs(root.left, root, h + 1);
        dfs(root.right, root, h + 1);
    }

    TreeNode findLCA(int startValue, int destValue) {
        TreeNode lca = null;
        while (startValue != destValue) {
            if (parent.get(startValue) == parent.get(destValue)) {
                lca = parent.get(startValue);
                break;
            }
            if (height.get(startValue) > height.get(destValue)) {
                if (parent.get(startValue).val == destValue)
                    lca = parent.get(startValue);
                startValue = parent.get(startValue).val;
            } else {
                if (parent.get(destValue).val == startValue)
                    lca = parent.get(destValue);
                destValue = parent.get(destValue).val;
            }
        }
        return lca;
    }

    boolean build(TreeNode lca, StringBuilder s, int destValue) {
        if (lca == null)
            return false;
        if (lca.val == destValue)
            return true;
        boolean l = build(lca.left, s, destValue);
        boolean r = build(lca.right, s, destValue);
        if (l) {
            s.append("L");
        } else if (r) {
            s.append("R");
        }
        return l || r;
    }
}