class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (k < arr[0])
            return k;
        k -= arr[0] - 1;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int missing = arr[i + 1] - arr[i] - 1;
            if (k <= missing)
                return arr[i] + k;
            k -= missing;
        }
        return arr[n - 1] + k;
    }
}