class Solution {
    public boolean isNumber(String s) {
        int idxE = -1;
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'e' || arr[i] == 'E') {
                if (idxE == -1) {
                    idxE = i;
                } else {
                    return false;
                }
            }
        }
        if (idxE != -1) {
            return check(arr, 0, idxE - 1, true) && check(arr, idxE + 1, n - 1, false);
        } else {
            return check(arr, 0, n - 1, true);
        }
    }

    boolean check(char[] arr, int start, int end, boolean isDecimal) {
        if (start > end)
            return false;
        int idxDot = -1;
        for (int i = start; i <= end; i++) {
            if (arr[i] == '.') {
                if (!isDecimal)
                    return false;
                if (idxDot == -1) {
                    idxDot = i;
                } else {
                    return false;
                }
            }
        }
        if (arr[start] == '+' || arr[start] == '-') {
            start++;
        }
        boolean hasDigit = false;
        for (int i = start; i <= end; i++) {
            if (arr[i] == '.')
                continue;
            if (arr[i] >= '0' && arr[i] <= '9') {
                hasDigit = true;
            } else
                return false;
        }
        return hasDigit;
    }
}