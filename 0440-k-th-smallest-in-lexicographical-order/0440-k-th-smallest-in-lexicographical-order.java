class Solution {
    int n;

    public int findKthNumber(int n, int k) {
        this.n = n;
        long cur = 1;
        k--;
        while (k > 0) {
            int cnt = count(cur);
            if (cnt <= k) {
                cur++;
                k -= cnt;
            } else {
                k--; // go down one step
                cur *= 10;
            }
        }
        return (int)cur;
    }

    int count(long cur) {
        long next = cur + 1;
        long cnt = 0;
        while (cur <= n) {
            cnt += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return (int)cnt;
    }
}