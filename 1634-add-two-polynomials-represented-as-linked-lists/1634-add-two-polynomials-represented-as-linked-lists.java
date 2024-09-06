/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode();
        PolyNode pre = dummy;
        while (poly1 != null && poly2 != null) {
            int p1 = poly1.power;
            int p2 = poly2.power;
            PolyNode cur;
            if (p1 > p2) {
                cur = new PolyNode(poly1.coefficient, p1);
                poly1 = poly1.next;
            } else if (p1 < p2) {
                cur = new PolyNode(poly2.coefficient, p2);
                poly2 = poly2.next;
            } else {
                if (poly1.coefficient + poly2.coefficient == 0) {
                    poly1 = poly1.next;
                    poly2 = poly2.next;
                    continue;
                }
                cur = new PolyNode(poly1.coefficient + poly2.coefficient, p1);
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
            pre.next = cur;
            pre = pre.next;
        }
        if (poly1 != null) {
            pre.next = poly1;
        }
        if (poly2 != null) {
            pre.next = poly2;
        }
        return dummy.next;
    }
}