class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            } else {
                list.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(new int[]{start, end});
        int[][] arr = new int[list.size()][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}