class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char a = s.charAt(left);
            if (!(a >= 'a' && a <= 'z') && !(a >= '0' && a <= '9')) {
                if (a >= 'A' && a <= 'Z') {
                    a += 32;
                } else {
                    left++;
                    continue;
                }
            }
            
            char b = s.charAt(right);
            if (!(b >= 'a' && b <= 'z') && !(b >= '0' && b <= '9')) {
                if (b >= 'A' && b <= 'Z')
                    b += 32;
                else {
                    right--;
                    continue;
                }
            }
            
            if (a != b)
                return false;
            left++;
            right--;
        }
        
        return true;
    }
}
