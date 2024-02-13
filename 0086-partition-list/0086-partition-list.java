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
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode ins = dummy;
        while (ins.next != null) {
            if (ins.next.val < x)
                ins = ins.next;
            else
                break;
        }
        ListNode cur = ins;
        while (cur.next != null) {
            if (cur.next.val < x) {
                ListNode move = cur.next;
                ListNode nxt = cur.next.next;
                cur.next = nxt;
                //
                ListNode nx = ins.next;
                ins.next = move;
                move.next = nx;
                ins = ins.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}