class Solution {
    public int countLetters(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count++;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}