class Solution {
    public int countLargestGroup(int n) {
        int[] t = new int[n + 1];
        int[] freq = new int[37]; // 9999: 36
        for (int i = 1; i <= n; i++) {
            t[i] = t[i / 10] + i % 10;
            freq[t[i]]++;
        }
        int max = 0;
        int count = 0;
        for (int i : freq) {
            if (max < i) {
                max = i;
                count = 0;
            }
            if (i == max)
                count++;
        }
        return count;
    }
}