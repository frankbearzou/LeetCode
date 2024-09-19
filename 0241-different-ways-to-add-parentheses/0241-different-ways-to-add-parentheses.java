class Solution {
    char[] s;

    public List<Integer> diffWaysToCompute(String expression) {
        s = expression.toCharArray();
        int n = s.length;
        return dfs(0, n - 1);
    }

    List<Integer> dfs(int l, int r) {
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (s[i] >= '0' && s[i] <= '9')
                continue;
            List<Integer> left = dfs(l, i - 1);
            List<Integer> right = dfs(i + 1, r);
            for (int a : left) {
                for (int b : right) {
                    if (s[i] == '+')
                        ans.add(a + b);
                    else if (s[i] == '-')
                        ans.add(a - b);
                    else if (s[i] == '*')
                        ans.add(a * b);
                }
            }
        }
        if (ans.isEmpty()) { // base case: numbers only
            int res = 0;
            for (int i = l; i <= r; i++)
                res = res * 10 + (s[i] - '0');
            ans.add(res);
        }
        return ans;
    }
}