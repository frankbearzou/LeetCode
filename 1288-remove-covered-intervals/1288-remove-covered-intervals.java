class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int count = 0;
        // sort by start point, if start point same, longer one first
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int pre = 0;
        for (int[] interval : intervals) {
            int end = interval[1];
            if (end >= pre) {
                count++;
                pre = end;
            }
        }
        return count;
    }
}