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
            ListNode ins = new ListNode(gcd(cur.val, next.val));
            cur.next = ins;
            ins.next = next;
            cur = next;
        }
        return head;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}