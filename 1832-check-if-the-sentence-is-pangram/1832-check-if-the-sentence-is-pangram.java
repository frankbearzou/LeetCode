class Solution {
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26)
            return false;
        char[] arr = sentence.toCharArray();
        int[] map = new int[26];
        for (char c : arr) {
            map[c - 'a']++;
        }
        for (int i : map) {
            if (i == 0)
                return false;
        }
        return true;
    }
}