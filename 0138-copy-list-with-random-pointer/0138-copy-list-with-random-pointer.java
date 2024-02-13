/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node newHead = dummy;
        Node h = head;
        while (head != null) {
            Node node = new Node(head.val);
            newHead.next = node;
            newHead = newHead.next;
            map.put(head, node);
            head = head.next;
        }
        head = h;
        while (head != null) {
            map.get(head).random = map.getOrDefault(head.random, null);
            head = head.next;
        }
        return dummy.next;
    }
}