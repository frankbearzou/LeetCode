class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        long sum = 0;
        int l = 0;
        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            if (r - l >= k)
                sum -= arr[l++];
            if (r - l + 1 == k) {
                if (sum >= k * threshold) {
                    count++;
                }
            }
        }
        return count;
    }
}