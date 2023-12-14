/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;
        int diff = 0;
        if (lenA > lenB) {
            diff = lenA - lenB;
            while (diff-- > 0) {
                curA = curA.next;
            }
        } else if (lenA < lenB) {
            diff = lenB - lenA;
            while (diff-- > 0) {
                curB = curB.next;
            }
        }
        while (curA != null && curB != null) {
            if (curA == curB)
                return curA;
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}