class Solution {
    public int longestPalindrome(String s) {
        int count = 0;
        boolean single = false;
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        for (int i : map) {
            if (i > 0) {
                if (i % 2 == 0)
                    count += i;
                else {
                    count += i - 1;
                    single = true;
                }
                    
            }
        }
        return count + (single ? 1 : 0);
    }
}