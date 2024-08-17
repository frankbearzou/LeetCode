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
    public int numComponents(ListNode head, int[] nums) {
        int count = 0;
        boolean starting = false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        while (head != null) {
            if (set.contains(head.val)) {
                if (!starting) {
                    starting = true;
                    count++;
                }
            } else {
                starting = false;
            }
            head = head.next;
        }
        return count;
    }
}