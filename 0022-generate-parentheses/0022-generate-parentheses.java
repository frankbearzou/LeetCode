class Solution {
    List<String> res = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0, "");
        return res;
    }

    void dfs(int open, int close, String path) {
        if (path.length() == 2 * n) {
            res.add(path);
            return;
        }
        if (open < n) {
            dfs(open + 1, close, path + "(");
        }
        if (open > close) {
            dfs(open, close + 1, path + ")");
        }
    }
}