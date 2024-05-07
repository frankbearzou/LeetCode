class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtracking(ans, "", n, 0, 0);
        return ans;
    }

    void backtracking(List<String> ans, String cur, int n, int open, int close) {
        if (cur.length() == n * 2) {
            ans.add(cur);
            return;
        }
        if (open < n)
            backtracking(ans, cur + "(", n, open + 1, close);
        if (close < open)
            backtracking(ans, cur + ")", n, open, close + 1);
    }
}