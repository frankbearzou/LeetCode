class Solution {
    List<String> ans = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0, "");
        return ans;
    }

    void dfs(int left, int right, String path) {
        if (path.length() == 2 * n) {
            ans.add(path);
            return;
        }
        if (left < n) {
            dfs(left + 1, right, path + "(");
        }
        if (left > right) {
            dfs(left, right + 1, path + ")");
        }
    }
}