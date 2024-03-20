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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode first = list1, second = list1;
        int i = a - 1;
        while (i-- > 0) {
            first = first.next;
        }
        second = first.next;
        i = b - a + 1;
        while (i-- > 0) {
            second = second.next;
        }
        first.next = list2;
        while (first.next != null) {
            first = first.next;
        }
        first.next = second;
        return list1;
    }
}