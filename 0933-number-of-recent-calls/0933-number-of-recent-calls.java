class RecentCounter {
    private List<Integer> list;

    public RecentCounter() {
        list = new ArrayList<>();
    }
    
    public int ping(int t) {
        list.add(t);
        int size = 1;
        int left = t - 3000;
        for (int i = list.size() - 2; i >= 0; i--) {
            if (list.get(i) >= left)
                size++;
        }
        return size;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */