class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int l, r;
        if (n % 2 == 0) {
            l = n / 2 - 1;
            r = n / 2;
            arr[l--] = -1;
            arr[r++] = 1;
        } else {
            l = r = n / 2;
            arr[l] = 0;
            l--;
            r++;
        }
        while (l >= 0 && r < n) {
            arr[l] = arr[l + 1] - 1;
            arr[r] = arr[r - 1] + 1;
            l--;
            r++;
        }
        return arr;
    }
}