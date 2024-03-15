class Solution {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int[] arr = new int[n + 1];
        arr[1] = arr[2] = 1;
        int sum = 2;
        for (int i = 2; i < n; i++) {
            arr[i + 1] = sum;
            sum += arr[i + 1];
            sum -= arr[i - 2];
        }
        return arr[n];
    }
}