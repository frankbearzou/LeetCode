class Solution {
    int ans;
    String s;
    int n;
    Set<String> set = new HashSet<>();

    public int maxUniqueSplit(String s) {
        this.s = s;
        n = s.length();
        dfs(0, 0);
        return ans;
    }

    void dfs(int start, int count) {
        if (start >= n) {
            ans = Math.max(ans, count);
            return;
        }
        for (int i = start + 1; i <= n; i++) {
            String str = s.substring(start, i);
            if (set.contains(str))
                continue;
            set.add(str);
            dfs(i, count + 1);
            set.remove(str);
        }
    }
}