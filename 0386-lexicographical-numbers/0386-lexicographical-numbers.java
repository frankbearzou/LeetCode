class Solution {
    int n;
    List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        for (int i = 1; i <= 9; i++) {
            dfs(i);
        }
        return ans;
    }

    void dfs(int num) {
        if (num <= n) {
            ans.add(num);
            for (int i = 0; i <= 9; i++) {
                dfs(num * 10 + i);
            }
        }
    }
}