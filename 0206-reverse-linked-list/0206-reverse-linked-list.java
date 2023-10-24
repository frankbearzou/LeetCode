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
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head, cur = head.next, post = head.next.next;
        pre.next = null;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            if (post != null) {
                cur = post;
                post = post.next;
            } else {
                return cur;
            }
        }
        return head;
    }
}