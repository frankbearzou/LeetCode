class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[][] events = new int[n * 2][2];
        for (int i = 0, j = 0; i < n; i++) {
            events[j++] = new int[]{intervals[i][0], 1};
            events[j++] = new int[]{intervals[i][1], -1};
        }
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return b[1] - a[1];
        });
        int max = 0;
        int cur = 0;
        for (int i = 0; i < events.length; i++) {
            cur += events[i][1];
            max = Math.max(max, cur);
        }
        return max;
    }
}