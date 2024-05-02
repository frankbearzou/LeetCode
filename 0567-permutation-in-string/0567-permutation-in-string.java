class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (char c : s1.toCharArray())
            map1[c - 'a']++;
        for (int i = 0; i < s2.length(); i++) {
            map2[s2.charAt(i) - 'a']++;
            if (i >= s1.length()) {
                map2[s2.charAt(i - s1.length()) - 'a']--;
            }
            if (Arrays.equals(map1, map2))
                return true;
        }
        return false;
    }
}