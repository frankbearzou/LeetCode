class Solution {
    public boolean checkValidString(String s) {
        int left = 0, star = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                left++;
            else if (c == '*')
                star++;
            else {
                if (left > 0)
                    left--;
                else if (star > 0)
                    star--;
                else
                    return false;
            }
        }
        return left == 0;
    }
}