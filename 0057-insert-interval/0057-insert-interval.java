class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                list.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }
                int size = list.size();
                int[][] ans = new int[size][2];
                for (int j = 0; j < ans.length; j++) {
                    ans[j] = list.get(j);
                }
                return ans;
            } else if (intervals[i][1] < newInterval[0]) {
                list.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        list.add(newInterval);
        int size = list.size();
        int[][] ans = new int[size][2];
        for (int j = 0; j < ans.length; j++) {
            ans[j] = list.get(j);
        }
        return ans;
    }
}