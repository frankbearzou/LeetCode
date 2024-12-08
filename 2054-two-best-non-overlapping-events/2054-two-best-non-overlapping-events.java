class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int ans = 0, max = 0;
        for (int[] event : events) {
            while (!queue.isEmpty() && queue.peek()[0] < event[0]) {
                max = Math.max(max, queue.peek()[1]);
                queue.remove();
            }
            ans = Math.max(ans, max + event[2]);
            queue.add(new int[]{event[1], event[2]});
        }
        return ans;
    }
}