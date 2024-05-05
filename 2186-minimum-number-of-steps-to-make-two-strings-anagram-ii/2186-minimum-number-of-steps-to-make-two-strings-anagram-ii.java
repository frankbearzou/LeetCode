class Solution {
    public int minSteps(String s, String t) {
        int count = 0;
        int[] arrs = new int[26], arrt = new int[26];
        for (char c : s.toCharArray()) {
            arrs[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            arrt[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            count += Math.abs(arrs[i] - arrt[i]);
        }
        return count;
    }
}