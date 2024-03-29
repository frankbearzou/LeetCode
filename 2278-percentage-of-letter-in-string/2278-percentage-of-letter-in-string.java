class Solution {
    public int percentageLetter(String s, char letter) {
        int i = 0, n = s.length();
        for (char c : s.toCharArray()) {
            if (c == letter)
                i++;
        }
        return i * 100 / n;
    }
}