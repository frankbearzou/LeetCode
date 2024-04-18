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
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);
        head = doubling(head);
        return reverse(head);
    }

    ListNode reverse(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    ListNode doubling(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        int carry = 0;
        while (head != null) {
            carry += head.val * 2;
            cur.next = new ListNode(carry % 10);
            cur = cur.next;
            carry /= 10;
            head = head.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}