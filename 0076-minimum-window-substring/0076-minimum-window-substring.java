class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";
        String ans = "";
        int minLen = Integer.MAX_VALUE;
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int count = t.length();
        int l = 0, r = 0;
        char[] arr = s.toCharArray();
        while (r < arr.length) {
            if (map[arr[r]] > 0) {
                count--;
            }
            map[arr[r]]--;
            r++;
            while (count == 0) {
                if (r - l < minLen) {
                    minLen = r - l;
                    ans = s.substring(l, r);
                }
                if (map[arr[l]] == 0) {
                    count++;
                }
                map[arr[l]]++;
                l++;
            }
        }
        return ans;
    }
}