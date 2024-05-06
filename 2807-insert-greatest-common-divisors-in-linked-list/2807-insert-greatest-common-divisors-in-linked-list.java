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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            ListNode ins = new ListNode(getDivisor(cur.val, next.val));
            cur.next = ins;
            ins.next = next;
            cur = next;
        }
        return head;
    }

    int getDivisor(int a, int b) {
        for (int i = Math.min(a, b); i >= 1; i--) {
            if ((a % i == 0) && (b % i == 0))
                return i;
        }
        return 1;
    }
}