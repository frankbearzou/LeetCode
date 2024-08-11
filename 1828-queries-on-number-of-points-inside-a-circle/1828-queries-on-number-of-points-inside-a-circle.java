class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int[] p : points) {
                if (dis(p, queries[i]))
                    count++;
            }
            res[i] = count;
        }
        return res;
    }

    boolean dis(int[] p1, int[]p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]) <= p2[2] * p2[2];
    }
}