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
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            while (!deque.isEmpty() && deque.peekLast().val < head.val)
                deque.pollLast();
            deque.offer(head);
            head = head.next;
        }
        head = deque.poll();
        ListNode cur = head;
        while (!deque.isEmpty()) {
            cur.next = deque.poll();
            cur = cur.next;
        }
        return head;
    }
}