/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    int len = 0;

    public boolean isSubPath(ListNode head, TreeNode root) {
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
            
        return dfs(head, root);
    }

    boolean dfs(ListNode head, TreeNode root) {
        if (root == null)
            return false;
        if (dfs(head, root, 0))
            return true;
        return dfs(head, root.left) || dfs(head, root.right);
    }

    boolean dfs(ListNode head, TreeNode root, int i) {
        if (i == len)
            return true;
        if (head == null || root == null)
            return false;
        if (root.val != head.val)
            return false;
        return dfs(head.next, root.left, i + 1) || dfs(head.next, root.right, i + 1);
    }
}