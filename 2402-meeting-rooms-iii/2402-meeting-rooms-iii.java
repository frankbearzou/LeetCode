class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        Queue<Integer> idle = new PriorityQueue<>();
        Queue<long[]> using = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        for (int i = 0; i < n; i++) {
            idle.offer(i);
        }
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for (int[] meeting : meetings) {
            int start = meeting[0];
            long end = meeting[1];
            while (!using.isEmpty() && using.peek()[0] <= start) {
                idle.offer((int)using.poll()[1]);
            }
            int id;
            if (!idle.isEmpty()) {
                id = idle.poll();
            } else {
                long[] poll = using.poll();
                end = end - start + poll[0];
                id = (int)poll[1];
            }
            count[id]++;
            using.offer(new long[]{end, id});
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}