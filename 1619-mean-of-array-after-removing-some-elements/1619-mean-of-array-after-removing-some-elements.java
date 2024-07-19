class Solution {
    public double trimMean(int[] arr) {
        long sum = 0;
        int n = arr.length;
        int skip = (int)(n * 0.05);
        Arrays.sort(arr);
        for (int i = skip; i < n - skip; i++) {
            sum += arr[i];
        }
        return 1.0 * sum / (n - 2 * skip);
    }
}