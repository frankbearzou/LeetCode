class MyLinkedList {

    private class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node = head;
        while (node != null && index != 0) {
            node = node.next;
            index--;
        }
        if (node != null && index == 0)
            return node.val;
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (head == null) {
            Node node = new Node(val);
            head = node;
            tail = node;
        } else {
            Node node = new Node(val);
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (tail == null) {
            Node node = new Node(val);
            head = node;
            tail = node;
        } else {
            Node node = new Node(val);
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;

        Node node = new Node(val);

        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }

        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        if (p == head) {
            node.next = head;
            head.prev = node;
            head = node;
        } else if (p == null) {
            tail.next = node;
            node.prev = tail;
            tail = node;
        } else {
            p.prev.next = node;
            node.prev = p.prev;
            node.next = p;
            p.prev = node;
        }
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size)
            return;

        if (index == 0 && size == 1) {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        Node p = head;
        for (int i = 0; i < index; i++)
            p = p.next;
        if (p == head) {
            head = head.next;
            head.prev = null;
            p = null;
        } else if (p == tail) {
            tail = tail.prev;
            tail.next = null;
            p = null;
        } else {
            p.prev.next = p.next;
            p.next.prev = p.prev;
            p = null;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
