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
    public ListNode mergeNodes(ListNode head) {
        ListNode h = head;
        ListNode cur = head.next;
        int sum = 0;
        while (cur != null) {
            if (cur.val != 0) {
                sum += cur.val;
                cur = cur.next;
            } else {
                cur.val = sum;
                sum = 0;
                h.next = cur;
                h = h.next;
                cur = cur.next;
            }
        }
        return head.next;
    }
}