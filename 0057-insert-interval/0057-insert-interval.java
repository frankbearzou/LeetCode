class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                list.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }
                int[][] res = new int[list.size()][2];
                for (int j = 0; j < res.length; j++) {
                    res[j] = list.get(j);
                }
                return res;
            } else if (intervals[i][1] < newInterval[0]) {
                list.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        list.add(newInterval);
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}