class Solution {
    public int minOperations(String s) {
        int zero = 0, one = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (arr[i] == '0')
                    one++;
                else
                    zero++;
            } else {
                if (arr[i] == '0')
                    zero++;
                else
                    one++;
            }
        }
        return Math.min(zero, one);
    }
}