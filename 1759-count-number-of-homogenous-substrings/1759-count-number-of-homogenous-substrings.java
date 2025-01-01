class Solution {
    public int countHomogenous(String s) {
        long count = 0;
        int l = 0, r = 0;
        int mod = (int)1e9 + 7;
        char[] arr = s.toCharArray();
        int n = arr.length;
        while (r <= n) {
            if (r == n || arr[l] != arr[r]) {
                long cnt = r - l;
                count = (count + (cnt * (cnt + 1) / 2) % mod) % mod;
                l = r;
                if (r == n)
                    break;
            } else {
                r++;
            }
        }
        return (int)count;
    }
}