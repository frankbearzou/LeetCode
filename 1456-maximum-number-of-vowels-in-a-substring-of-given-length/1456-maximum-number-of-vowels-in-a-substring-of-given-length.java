class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');
        int res = 0;
        int l = 0, count = 0, n = s.length();
        for (int r = 0; r < n; r++) {
            if (r - l == k) {
                if (vowel.contains(s.charAt(l))) {
                    count--;
                }
                l++;
            }
            if (vowel.contains(s.charAt(r))) {
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}