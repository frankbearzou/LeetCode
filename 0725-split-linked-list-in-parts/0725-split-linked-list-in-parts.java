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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cur = head;
        int n = 0;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        int each = n / k;
        int mod = n % k;
        cur = head;
        ListNode pre = cur;
        ListNode[] ans = new ListNode[k];
        for (int i = 0; i < k; i++) {
            int j = 0;
            ListNode sub = cur;
            int m = 0;
            if (mod > 0) {
                m = 1;
                mod--;
            }
            for (j = 0; j < each + m; j++) {
                pre = cur;
                cur = cur.next;
            }
            if (pre != null)
                pre.next = null;
            ans[i] = sub;
        }
        return ans;
    }
}