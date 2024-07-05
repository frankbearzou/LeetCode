class Solution {
    public int[] processQueries(int[] queries, int m) {
        int n = queries.length;
        int[] ans = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (list.get(j) == queries[i]) {
                    ans[i] = j;
                    list.remove(j);
                    list.add(0, queries[i]);
                    break;
                }
            }
        }
        return ans;
    }
}