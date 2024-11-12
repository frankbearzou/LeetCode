class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int max = 0;
        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];
            int cur = map.getOrDefault(price, 0);
            max = Math.max(max, Math.max(beauty, cur));
            map.put(price, max);
        }
        for (int i = 0; i < n; i++) {
            Integer key = map.floorKey(queries[i]);
            if (key == null) {
                ans[i] = 0;
            } else {
                ans[i] = map.get(key);
            }
        }
        return ans;
    }
}