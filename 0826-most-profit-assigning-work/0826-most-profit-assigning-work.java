class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int sum = 0;
        int n = difficulty.length;
        Pair[] pair = new Pair[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Pair(difficulty[i], profit[i]);
        }
        Arrays.sort(pair, (a, b) -> a.d - b.d);
        Queue<Integer> pq = new PriorityQueue<>();
        for (int work : worker) {
            pq.clear();
            for (int i = 0; i < n; i++) {
                if (pair[i].d <= work) {
                    pq.offer(pair[i].p);
                    if (pq.size() > 1) {
                        pq.poll();
                    }
                } else {
                    break;
                }
            }
            if (!pq.isEmpty())
                sum += pq.poll();
        }
        return sum;
    }
}

class Pair {
    int d;
    int p;
    Pair(int d, int p) {
        this.d = d;
        this.p = p;
    }
}