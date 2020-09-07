class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> {
            if (a[1] != b[1])
                return b[1] - a[1];
            else
                return b[0] - a[0];
        });
        int[] ans = new int[k];
        
        for (int i = 0; i < mat.length; i++) {
            int soldiers = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    soldiers++;
                else
                    break;
            }
            queue.add(new int[] {i, soldiers});
            if (queue.size() > k)
                queue.poll();
        }
        for (int i = k - 1; i >= 0; i--)
            ans[i] = queue.poll()[0];
        
        return ans;
    }
}
