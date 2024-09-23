class Solution {
    String s;
    int n;
    Set<String> set = new HashSet<>();
    int[] cache;

    public int minExtraChar(String s, String[] dictionary) {
        this.s = s;
        n = s.length();
        for (String dic : dictionary)
            set.add(dic);
        cache = new int[n];
        Arrays.fill(cache, -1);
        return dfs(0);
    }

    int dfs(int start) {
        if (start == n)
            return 0;
        if (cache[start] != -1)
            return cache[start];
        // not choose
        int ans = dfs(start + 1) + 1;
        // choose
        for (int i = start; i < n; i++) {
            String str = s.substring(start, i + 1);
            if (set.contains(str)) {
                ans = Math.min(ans, dfs(i + 1));
            }
        }
        return cache[start] = ans;
    }
}