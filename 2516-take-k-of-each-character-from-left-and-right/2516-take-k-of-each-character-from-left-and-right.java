class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0)
            return 0;
        int len = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        for (char c : s.toCharArray()) {
            map.put(c, map.get(c) + 1);
        }
        Map<Character, Integer> win = new HashMap<>();
        win.put('a', 0);
        win.put('b', 0);
        win.put('c', 0);
        if (!valid(map, win, k))
            return -1;
        int l = 0;
        for (int r = 0; r < n; r++) {
            char rightChar = s.charAt(r);
            win.put(rightChar, win.get(rightChar) + 1);
            while (!valid(map, win, k)) {
                char leftChar = s.charAt(l);
                win.put(leftChar, win.get(leftChar) - 1);
                l++;
            }
            len = Math.max(len, r - l + 1);
        }
        return n - len;
    }

    boolean valid(Map<Character, Integer> map, Map<Character, Integer> win, int k) {
        if (map.get('a') - win.get('a') >= k && map.get('b') - win.get('b') >= k && map.get('c') - win.get('c') >= k)
            return true;
        return false;
    }
}