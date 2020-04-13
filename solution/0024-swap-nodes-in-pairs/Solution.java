/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        while (head != null && head.next != null) {
            ListNode second = head.next;
            ListNode third = second.next != null ? second.next : null;
            ListNode fourth = third != null && third.next != null ? third.next : null;
            
            second.next = head;
            head.next = fourth == null ? third : fourth;
            head = third;
        }
        return newHead;
    }
}
