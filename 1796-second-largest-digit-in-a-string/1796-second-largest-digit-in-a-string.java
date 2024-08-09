class Solution {
    public int secondHighest(String s) {
        int[] map = new int[10];
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                map[c - '0']++;
            }
        }
        int largest = -1;
        for (int i = 9; i >= 0; i--) {
            if (map[i] != 0) {
                if (largest == -1) {
                    largest = map[i];
                } else {
                    return map[i];
                }
            }
        }
        return -1;
    }
}