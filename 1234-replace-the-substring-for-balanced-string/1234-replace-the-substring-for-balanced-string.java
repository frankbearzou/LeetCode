class Solution {
    public int balancedString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length, m = n / 4, l = 0;
        int res = n;
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', 0);
        map.put('W', 0);
        map.put('E', 0);
        map.put('R', 0);
        for (char c : arr) {
            map.put(c, map.get(c) + 1);
        }
        if (map.get('Q') == m && map.get('W') == m && map.get('E') == m && map.get('R') == m)
            return 0;
        for (int r = 0; r < n; r++) {
            map.put(arr[r], map.get(arr[r]) - 1);
            while (map.get('Q') <= m && map.get('W') <= m && map.get('E') <= m && map.get('R') <= m) {
                res = Math.min(res, r - l + 1);
                map.put(arr[l], map.get(arr[l]) + 1);
                l++;
            }
        }
        return res;
    }
}