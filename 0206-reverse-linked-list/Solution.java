/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode pos = null;
        
        while (cur != null) {
            pos = cur.next;
            cur.next = pre;
            pre = cur;
            cur = pos;
        }
        
        return pre;
    }
}
