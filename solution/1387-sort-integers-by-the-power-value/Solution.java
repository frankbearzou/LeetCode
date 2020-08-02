class Solution {
    public int getKth(int lo, int hi, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a, b) -> {
                    if (a[1] != b[1])
                        return b[1] - a[1];
                    else
                        return b[0] - a[0];
                });
        
        for (int i = lo; i <= hi; i++) {
            int val = i;
            int step = 0;
            while (val != 1) {
                if (val % 2 == 0)
                    val /= 2;
                else
                    val = 3 * val + 1;
                step++;
            }
            q.add(new int[] {i, step});
            if (q.size() > k)
                q.poll();
        }
        
        return q.poll()[0];
    }
}
