class MedianFinder {
    private Queue<Integer> minStack;
    private Queue<Integer> maxStack;
    public MedianFinder() {
        minStack = new PriorityQueue<>();
        maxStack = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if (minStack.size() == maxStack.size()) {
            minStack.offer(num);
            maxStack.offer(minStack.poll());
        } else {
            maxStack.offer(num);
            minStack.offer(maxStack.poll());
        }
    }
    
    public double findMedian() {
        if (minStack.size() == maxStack.size()) {
            return (minStack.peek() + maxStack.peek()) / 2.0;
        } else {
            return maxStack.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */