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
    public void reorderList(ListNode head) {
        ListNode cur = head;
        Deque<ListNode> deque = new ArrayDeque<>();
        while (cur != null) {
            deque.offer(cur);
            cur = cur.next;
        }
        cur = new ListNode();
        int i = 0;
        while (!deque.isEmpty()) {
            if (i % 2 == 0) {
                cur.next = deque.poll();
            } else {
                cur.next = deque.pollLast();
            }
            cur = cur.next;
            i++;
        }
        cur.next = null;
    }
}