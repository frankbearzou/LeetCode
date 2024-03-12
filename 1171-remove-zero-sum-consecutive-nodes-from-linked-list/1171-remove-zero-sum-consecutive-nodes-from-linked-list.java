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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        int prefix = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (cur != null) {
            prefix += cur.val;
            map.put(prefix, cur);
            cur = cur.next;
        }
        prefix = 0;
        cur = dummy;
        while (cur != null) {
            prefix += cur.val;
            cur.next = map.get(prefix).next;
            cur = cur.next;
        }
        return dummy.next;
    }
}