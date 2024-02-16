class Solution {
    public int myAtoi(String s) {
        char[] arr = s.trim().toCharArray();
        if (arr.length == 0)
            return 0;
        int sign = 1;
        int start = 1;
        int res = 0;
        int bound = Integer.MAX_VALUE / 10;
        if (arr[0] == '-') {
            sign = -1;
        } else if (arr[0] != '+') {
            start = 0;
        }
        for (int i = start; i < arr.length; i++) {
            if (arr[i] < '0' || arr[i] > '9')
                break;
            if (res > bound || (res == bound && arr[i] > '7'))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (arr[i] - '0');
        }
        return res * sign;
    }
}