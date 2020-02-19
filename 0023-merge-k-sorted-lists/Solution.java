/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ListNode head = new ListNode(0);
        ListNode p = head;
        
        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }
        
        while (queue.size() > 0) {
            p.next = new ListNode(queue.poll());
            p = p.next;
        }
        
        return head.next;
    }
}
