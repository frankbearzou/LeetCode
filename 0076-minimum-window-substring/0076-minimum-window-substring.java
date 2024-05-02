class Solution {
    public String minWindow(String s, String t) {
        int len = Integer.MAX_VALUE;
        String res = "";
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (char c : t.toCharArray()) {
            m2.put(c, m2.getOrDefault(c, 0) + 1);
        }
        int l = 0, n = s.length();
        for (int r = 0; r < n; r++) {
            char c = s.charAt(r);
            if (m2.containsKey(c)) {
                m1.put(c, m1.getOrDefault(c, 0) + 1);
                while (contains(m1, m2)) {
                    if (r - l + 1 < len) {
                        len = r - l + 1;
                        res = s.substring(l, r + 1);
                    }
                    if (m1.containsKey(s.charAt(l))) {
                        m1.put(s.charAt(l), m1.get(s.charAt(l)) - 1);
                    }
                    l++;
                }
            }
        }
        return res;
    }

    boolean contains(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        if (m1.size() != m2.size())
            return false;
        for (var entry : m2.entrySet()) {
            if (m1.getOrDefault(entry.getKey(), 0) < m2.get(entry.getKey()))
                return false;
        }
        return true;
    }
}