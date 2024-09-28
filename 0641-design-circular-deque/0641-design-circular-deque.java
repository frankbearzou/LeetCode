class MyCircularDeque {
    private int total;
    private int size;
    private Node head;
    private Node tail;

    public MyCircularDeque(int k) {
        total = k;
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        Node next = head.next;
        Node cur = new Node(value, head, next);
        head.next = cur;
        next.prev = cur;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        Node prev = tail.prev;
        Node cur = new Node(value, prev, tail);
        prev.next = cur;
        tail.prev = cur;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        Node next = head.next.next;
        head.next = next;
        next.prev = head;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        Node prev = tail.prev.prev;
        tail.prev = prev;
        prev.next = tail;
        size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty())
            return -1;
        return head.next.val;
    }
    
    public int getRear() {
        if (isEmpty())
            return -1;
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == total;
    }
}

class Node {
    int val;
    Node prev;
    Node next;

    Node() {

    }
    
    Node(int val, Node prev, Node next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */