class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int i : rolls)
            sum += i;
        sum = mean * (n + rolls.length) - sum;
        if (n * 6 < sum || sum < n)
            return new int[0];
        int[] arr = new int[n];
        for (int i = n; i > 0; i--) {
            arr[i - 1] = sum / i;
            sum -= arr[i - 1];
        }
        return arr;
    }
}