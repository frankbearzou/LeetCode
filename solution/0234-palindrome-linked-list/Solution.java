/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        ListNode fast = head, slow = head;
        // use fast and slow to find middle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null)
            slow = slow.next;
        
        slow = reverse(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head, pos = null;
        
        while (cur != null) {
            pos = cur.next;
            cur.next = pre;
            pre = cur;
            cur = pos;
        }
        
        return pre;
    }
}
