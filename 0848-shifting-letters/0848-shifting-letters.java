class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        StringBuilder res = new StringBuilder();
        int n = shifts.length;
        for (int i = n - 2; i >= 0; i--)
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26;
        for (int i = 0; i < n; i++) {
            res.append((char)('a' + ((s.charAt(i) + shifts[i] - 'a') % 26)));
        }
        return res.toString();
    }
}