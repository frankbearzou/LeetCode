class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[][]{};
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (list.get(list.size() - 1)[1] >= intervals[i][0]) {
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            } else {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
