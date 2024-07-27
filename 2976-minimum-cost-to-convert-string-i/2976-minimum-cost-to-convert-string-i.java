class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long ans = 0;
        int n = original.length;
        long[][] dist = new long[26][26];
        for (int i  = 0; i < 26; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }
        // cost matrix
        for (int i = 0; i < n; i++) {
            int start = original[i] - 'a';
            int end = changed[i] - 'a';
            int c = cost[i];
            dist[start][end] = Math.min(dist[start][end], c);
        }
        // Floyd Warshall algorithm
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] != Long.MAX_VALUE && dist[k][j] != Long.MAX_VALUE
                        && dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        // calculate cost
        for (int i = 0; i < source.length(); i++) {
            int start = source.charAt(i) - 'a';
            int end = target.charAt(i) - 'a';
            if (start == end)
                continue;
            if (dist[start][end] == Long.MAX_VALUE)
                return -1;
            ans += dist[start][end];
        }
        return ans;
    }
}