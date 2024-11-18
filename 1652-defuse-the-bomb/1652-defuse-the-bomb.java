class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 1; j <= Math.abs(k); j++) {
                if (k > 0) {
                    sum += code[(i + j) % n];
                } else {
                    sum += code[(i - j + n) % n];
                }
            }
            ans[i] = sum;
        }
        return ans;
    }
}