class Solution {
    int[] days;
    int[] costs;
    int[] cache;
    Set<Integer> set = new HashSet<>();
    int lastday;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        lastday = days[days.length - 1];
        cache = new int[lastday + 1];
        Arrays.fill(cache, -1);
        for (int day : days)
            set.add(day);
        return dfs(1);
    }

    int dfs(int cur) {
        if (cur > lastday)
            return 0;
        if (!set.contains(cur))
            return dfs(cur + 1);
        if (cache[cur] != -1)
            return cache[cur];
        int one = costs[0] + dfs(cur + 1);
        int seven = costs[1] + dfs(cur + 7);
        int thirty = costs[2] + dfs(cur + 30);
        return cache[cur] = Math.min(one, Math.min(seven, thirty));
    }
}