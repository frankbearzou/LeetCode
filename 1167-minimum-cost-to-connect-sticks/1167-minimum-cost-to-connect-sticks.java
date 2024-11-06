class Solution {
    public int connectSticks(int[] sticks) {
        int n = sticks.length;
        if (n == 1)
            return 0;
        Arrays.sort(sticks);
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sticks[i] += sticks[i - 1];
            sum += sticks[i];
        }
        return sum;
    }
}