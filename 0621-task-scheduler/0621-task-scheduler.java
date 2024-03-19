class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count = 0;
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> q = new LinkedList<>();
        for (int num : map) {
            if (num > 0)
                pq.offer(num);
        }
        while (!pq.isEmpty() || !q.isEmpty()) {
            int k = n + 1;
            while (k > 0 && !pq.isEmpty()) {
                int top = pq.poll();
                q.offer(--top);
                k--;
                count++;
            }
            while (!q.isEmpty()) {
                int top = q.poll();
                if (top > 0)
                    pq.offer(top);
            }
            if (pq.isEmpty())
                break;
            count += k;
        }
        return count;
    }
}