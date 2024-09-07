class Solution {
    int n;
    List<String> ans = new ArrayList<>();
    char[] digits;
    char[] path;
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        n = digits.length();
        if (n == 0)
            return ans;
        this.digits = digits.toCharArray();
        path = new char[n];
        dfs(0);
        return ans;
    }

    void dfs(int i) {
        if (i == n) {
            ans.add(new String(path));
            return;
        }
        for (char c : map[digits[i] - '0'].toCharArray()) {
            path[i] = c;
            dfs(i + 1);
        }
    }
}