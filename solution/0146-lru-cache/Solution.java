class Node {
    public int key, value;
    public Node prev, next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleList {
    private Node head, tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void add(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeLast() {
        if (tail.prev == head)
            return null;
        Node node = tail.prev;
        remove(node);
        return node;
    }

    public int size() {
        return size;
    }
}

class LRUCache {
    private DoubleList cache;
    private HashMap<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        cache.remove(node);
        cache.add(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);

        if (map.containsKey(key)) {
            Node old = map.get(key);
            cache.remove(old);
            cache.add(node);
            map.remove(key);
            map.put(key, node);
        } else {
            if (cache.size() == capacity) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.add(node);
            map.put(key, node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
