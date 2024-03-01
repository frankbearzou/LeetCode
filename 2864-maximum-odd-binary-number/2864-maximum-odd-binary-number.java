class Solution {
    public String maximumOddBinaryNumber(String s) {
        int zero = 0, one = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                zero++;
            else
                one++;
        }
        int n = zero + one;
        char[] arr = new char[n];
        arr[n - 1] = '1';
        one--;
        for (int i = n - 2; i >= 0; i--) {
            if (zero-- > 0)
                arr[i] = '0';
            else
                arr[i] = '1';
        }
        return new String(arr);
    }
}