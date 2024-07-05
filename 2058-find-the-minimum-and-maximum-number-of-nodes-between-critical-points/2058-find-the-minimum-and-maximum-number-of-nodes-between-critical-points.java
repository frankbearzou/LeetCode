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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;
        List<Integer> list = new ArrayList<>();
        ListNode pre = head;
        head = head.next;
        int index = 1;
        while (head.next != null) {
            if (head.val < pre.val && head.val < head.next.val) {
                list.add(index);
            } else if (head.val > pre.val && head.val > head.next.val) {
                list.add(index);
            }
            pre = head;
            head = head.next;
            index++;
        }
        if (list.size() <= 1)
            return new int[]{-1, -1};
        for (int i = 1; i < list.size(); i++) {
            minDistance = Math.min(minDistance, list.get(i) - list.get(i - 1));
        }
        maxDistance = list.getLast() - list.getFirst();
        return new int[]{minDistance, maxDistance};
    }
}