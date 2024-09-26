class MyCalendar {
    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if ((calendar.floorKey(start) == null || calendar.get(calendar.floorKey(start)) <= start) &&
            (calendar.ceilingKey(start) == null || calendar.ceilingKey(start) >= end)) {
                calendar.put(start, end);
                return true;
            }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */