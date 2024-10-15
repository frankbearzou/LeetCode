class FirstUnique {
    private Map<Integer, Node> map;
    private Set<Integer> set;
    private Node head;
    private Node tail;

    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        set = new HashSet<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        
        for (int num : nums) {
            add(num);
        }
    }
    
    public int showFirstUnique() {
        if (head.next == tail)
            return -1;
        return head.next.val;
    }
    
    public void add(int value) {
        if (set.contains(value))
            return;
        if (map.containsKey(value)) {
            Node node = map.get(value);
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            map.remove(value);
            set.add(value);
        } else {
            Node prev = tail.prev;
            Node node = new Node(value, prev, tail);
            prev.next = node;
            tail.prev = node;
            map.put(value, node);
        }
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
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */