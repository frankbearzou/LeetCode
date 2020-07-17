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
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        
        StringBuilder num = new StringBuilder();
        while (head != null) {
            num.append(head.val);
            head = head.next;
        }
        
        for (int i = num.length() - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            if (ch == '1') {
                ans += (int)Math.pow(2, num.length() - i - 1);
            }
        }
        
        return ans;
    }
}
