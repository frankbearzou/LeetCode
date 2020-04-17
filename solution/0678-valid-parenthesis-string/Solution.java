class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lo++;
                hi++;
            } else if (c == '*') {
                if (lo > 0)
                    lo--;
                hi++;
            } else {
                if (lo > 0)
                    lo--;
                hi--;
            }
            if (hi < 0)
                return false;
        }
        return lo == 0;
    }
}
