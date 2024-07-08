class Solution {
    public int findTheWinner(int n, int k) {
        int[] arr = new int[n];
        int i = 0;
        int times = n - 1;
        while (times > 0) {
            int t = k;
            while (t > 0) {
                if (i == n) {
                    i = 0;
                }
                if (arr[i] == 0) {
                    t--;
                    if (t == 0) {
                        arr[i] = 1;
                        times--;
                    }
                }
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] == 0)
                return j + 1;
        }
        return 0;
    }
}