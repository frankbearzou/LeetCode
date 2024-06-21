class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int count = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                count += customers[i];
            }
        }
        int max = 0;
        int len = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (r >= minutes && grumpy[r - minutes] == 1) {
                len -= customers[r - minutes];
            }
            if (grumpy[r] == 1) {
                len += customers[r];
                max = Math.max(max, len);
            }
        }
        return count + max;
    }
}