class KthLargest {
    private Queue<Integer> queue;
    private int k;

    public KthLargest(int k, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums)
            list.add(i);
        queue = new PriorityQueue<>(list);
        while (queue.size() > k)
            queue.remove();
        this.k = k;
    }
    
    public int add(int val) {
        queue.add(val);
        if (queue.size() > k)
            queue.remove();
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */