class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            map.putIfAbsent(item[0], new PriorityQueue<>());
            map.get(item[0]).offer(item[1]);
            if (map.get(item[0]).size() > 5)
                map.get(item[0]).poll();
        }
        int[][] ans = new int[map.size()][2];
        int i = 0;
        for (var entry : map.entrySet()) {
            ans[i][0] = entry.getKey();
            int sum = 0;
            for (int score : entry.getValue()) {
                sum += score;
            }
            ans[i][1] = sum / 5;
            i++;
        }
        Arrays.sort(ans, (a, b) -> a[0] - b[0]);
        return ans;
    }
}