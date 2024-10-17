class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int)(s.charAt(i) - '0');
        }
        int[] map = new int[n];
        // get the max index from end to start
        for (int i = n - 1, max = n - 1; i >= 0; i--) {
            if (s.charAt(i) > s.charAt(max))
                max = i;
            map[i] = max;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != arr[map[i]]) {
                int val = arr[i];
                arr[i] = arr[map[i]];
                arr[map[i]] = val;
                break;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans * 10 + arr[i];
        }
        return ans;
    }
}