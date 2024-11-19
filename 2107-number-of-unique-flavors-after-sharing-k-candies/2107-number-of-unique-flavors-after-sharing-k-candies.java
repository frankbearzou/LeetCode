class Solution {
    public int shareCandies(int[] candies, int k) {
        int ans = 0;
        int n = candies.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int candy : candies) {
            map.put(candy, map.getOrDefault(candy, 0) + 1);
        }
        if (k == 0) {
            return map.size();
        }
        int l = 0;
        for (int r = 0; r < n; r++) {
            int t = map.get(candies[r]);
            if (t == 1) {
                map.remove(candies[r]);
            } else {
                map.put(candies[r], t - 1);
            }
            if (r >= k) {
                map.put(candies[l], map.getOrDefault(candies[l], 0) + 1);
                l++;
            }
            if (r - l + 1 == k) {
                ans = Math.max(ans, map.size());
            }
        }
        return ans;
    }
}