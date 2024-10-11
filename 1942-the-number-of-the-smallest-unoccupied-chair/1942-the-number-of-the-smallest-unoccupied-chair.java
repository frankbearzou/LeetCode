class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        // [time, type, friendIndex]. type: 0: arrival, 1: leaving
        int[][] events = new int[2 * n][3];
        for (int i = 0, j = 0; i < n; i++) {
            events[j++] = new int[]{times[i][0], 0, i};
            events[j++] = new int[]{times[i][1], 1, i};
        }
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        Queue<Integer> chairs = new PriorityQueue<>();
        int[] occupy = new int[n];
        for (int i = 0; i < n; i++) {
            chairs.add(i);
        }
        for (int[] event : events) {
            int time = event[0];
            int type = event[1];
            int friendIndex = event[2];
            if (type == 0) {
                // arrival
                int chair = chairs.remove();
                if (friendIndex == targetFriend)
                    return chair;
                occupy[friendIndex] = chair;
            } else {
                // leaving
                int chair = occupy[friendIndex];
                chairs.add(chair);
            }
        }
        return -1;
    }
}