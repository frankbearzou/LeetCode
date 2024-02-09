class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L')
                l++;
            else
                r++;
            if (l == r) {
                count++;
                l = 0;
                r = 0;
            }
        }
        return count;
    }
}