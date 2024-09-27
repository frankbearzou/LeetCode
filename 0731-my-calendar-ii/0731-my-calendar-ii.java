class MyCalendarTwo {
    private List<int[]> single;
    private List<int[]> multiple;

    public MyCalendarTwo() {
        single = new ArrayList<>();
        multiple = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (int[] line : multiple) {
            if (isOverlap(start, end, line[0], line[1]))
                return false;
        }
        for (int[] line : single) {
            if (isOverlap(start, end, line[0], line[1])) {
                multiple.add(getOverlap(start, end, line[0], line[1]));
            }
        }
        single.add(new int[]{start, end});
        return true;
    }

    private boolean isOverlap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    private int[] getOverlap(int start1, int end1, int start2, int end2) {
        return new int[]{Math.max(start1, start2), Math.min(end1, end2)};
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */