class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        Integer[][][] cache = new Integer[601][101][101];
        return dfs(strs, 0, m, n, cache);
    }

    int dfs(String[] strs, int index, int zeros, int ones, Integer[][][] cache) {
        if (index >= strs.length)
            return 0;
        if (zeros == 0 && ones == 0)
            return 0;
        if (cache[index][zeros][ones] != null)
            return cache[index][zeros][ones];
        String str = strs[index];
        int zero = 0, one = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }
        if (zero > zeros || one > ones)
            return dfs(strs, index + 1, zeros, ones, cache);
        int no = dfs(strs, index + 1, zeros, ones, cache);
        int yes = dfs(strs, index + 1, zeros - zero, ones - one, cache) + 1;
        cache[index][zeros][ones] = Math.max(no, yes);
        return cache[index][zeros][ones];
    }
}