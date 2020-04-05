/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode tail = head;
        ListNode cur = head.next;

        while (cur != null) {
            if (cur.val != tail.val) {
                tail.next = cur;
                tail = tail.next;
            }

            cur = cur.next;
        }

        tail.next = cur;

        return head;
    }
}
