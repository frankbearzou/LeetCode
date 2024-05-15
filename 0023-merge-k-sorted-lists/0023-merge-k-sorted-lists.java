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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for (ListNode node : lists) {
            ListNode cur = node;
            while (cur != null) {
                pq.offer(cur.val);
                cur = cur.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            cur.next = new ListNode(pq.poll());
            cur = cur.next;
        }
        return dummy.next;
    }
}