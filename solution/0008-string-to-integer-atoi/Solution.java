class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        int sign = 1;
        int result = 0;
        
        // skip white spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // sign
        if (i < n && s.charAt(i) == '+') {
            sign = 1;
            i++;
        } else if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int value = s.charAt(i) - '0';
            
            // overflow
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && value > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + value;
            i++;
        }
        
        return result * sign;
    }
}
