class Solution {
    public int nthUglyNumber(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            arr[i] = Math.min(2 * arr[a], Math.min(3 * arr[b], 5 * arr[c]));
            if (arr[i] == 2 * arr[a])
                a++;
            if (arr[i] == 3 * arr[b])
                b++;
            if (arr[i] == 5 * arr[c])
                c++;
        }
        return arr[n - 1];
    }
}