class Solution {
    public boolean checkZeroOnes(String s) {
        return count(s, '1') > count(s, '0');
    }
    
    int count(String s, char ch) {
        int res = 0;
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == ch) {
                res = Math.max(res, ++cnt);
            } else {
                cnt = 0;
            }
        }
        return res;
    }
}