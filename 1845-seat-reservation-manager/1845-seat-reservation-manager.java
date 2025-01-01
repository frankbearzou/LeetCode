class SeatManager {
    private PriorityQueue<Integer> queue;

    public SeatManager(int n) {
        queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
    }
    
    public int reserve() {
        return queue.remove();
    }
    
    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */