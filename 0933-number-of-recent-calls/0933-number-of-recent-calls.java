class RecentCounter {
    private List<Integer> list;
    private int start;

    public RecentCounter() {
        list = new ArrayList<>();
        start = 0;
    }
    
    public int ping(int t) {
        while (start < list.size() && t - list.get(start) > 3000)
            start++;
        list.add(t);
        return list.size() - start;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */