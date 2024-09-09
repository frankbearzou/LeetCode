class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int k;
    int n;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        dfs(1);
        return res;
    }

    void dfs(int start) {
        if (path.size() == k) {
            int sum = 0;
            for (int i : path)
                sum += i;
            if (sum == n) {
                res.add(new ArrayList(path));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.add(i);
            dfs(i + 1);
            path.removeLast();
        }
    }
}