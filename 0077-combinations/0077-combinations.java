class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(1);
        return res;
    }

    void dfs(int start) {
        if (path.size() == k) {
            res.add(new ArrayList(path));
            return;
        }
        for (int i = start;i <= n; i++) {
            path.add(i);
            dfs(i + 1);
            path.removeLast();
        }
    }
}