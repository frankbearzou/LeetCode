class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int res = 1;
        int l = 0, r = 1;
        char sign = '0';
        while (r < arr.length) {
            if (arr[r - 1] < arr[r] && sign != '<') {
                res = Math.max(res, r - l + 1);
                sign = '<';
                r++;
            } else if (arr[r - 1] > arr[r] && sign != '>') {
                res = Math.max(res, r - l + 1);
                sign = '>';
                r++;
            } else {
                if (arr[r - 1] == arr[r])
                    r++;
                l = r - 1;
                sign = '0';
            }
        }
        return res;
    }
}