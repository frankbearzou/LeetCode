class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int m = monsters.length;
        Mon[] mon = new Mon[m];
        for (int i = 0; i < m; i++) {
            mon[i] = new Mon(monsters[i], coins[i]);
        }
        Arrays.sort(mon, (a, b) -> a.m() - b.m());
        TreeMap<Integer, Long> map = new TreeMap<>();
        long sum = 0;
        for (Mon mm : mon) {
            map.put(mm.m(), mm.c() + sum);
            sum += mm.c();
        }
        
        int n = heroes.length;
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            Integer key = map.floorKey(heroes[i]);
            if (key != null)
                ans[i] = map.get(key);
        }
        return ans;
    }
}

record Mon(int m, int c){}