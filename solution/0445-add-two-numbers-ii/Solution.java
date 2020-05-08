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
    private Stack<Integer> getStack(ListNode list) {
        Stack<Integer> stack = new Stack<>();
        while (list != null) {
            stack.push(list.val);
            list = list.next;
        }
        return stack;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = getStack(l1);
        Stack<Integer> s2 = getStack(l2);
        int carry = 0;
        ListNode cur = null, prev = null;
        
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int a = s1.isEmpty() ? 0 : s1.pop();
            int b = s2.isEmpty() ? 0 : s2.pop();
            cur = new ListNode((a + b + carry) % 10);
            carry = (a + b + carry) / 10;
            cur.next = prev;
            prev = cur;
        }
        
        if (carry == 1) {
            cur = new ListNode(carry);
            cur.next = prev;
        }
        
        return cur;
    }
}
