class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            map.put("" + c, map.getOrDefault("" + c, 0) + 1);
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) != c)
                    break;
                String str = s.substring(i, j + 1);
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        int ans = -1;
        for (var entry : map.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (val >= 3) {
                ans = Math.max(ans, key.length());
            }
        }
        return ans;
    }
}