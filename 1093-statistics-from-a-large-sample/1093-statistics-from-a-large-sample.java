class Solution {
    public double[] sampleStats(int[] count) {
        double[] ans = new double[5];
        int n = count.length;
        // minimum
        for (int i = 0; i < n; i++) {
            if (count[i] != 0) {
                ans[0] = i;
                break;
            }
        }
        // maximum
        for (int i = n - 1; i >= 0; i--) {
            if (count[i] != 0) {
                ans[1] = i;
                break;
            }
        }
        // mean
        double sum = 0;
        int size = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] != 0) {
                sum += count[i] * i;
                size += count[i];
                cnt++;
            }
        }
        ans[2] = sum / size;
        // median
        if (size % 2 == 0) {
            int cur = 0;
            for (int i = 0; i < n; i++) {
                cur += count[i];
                if (cur >= size / 2 + 1) {
                    ans[3] = i;
                    break;
                } else if (cur == size / 2) {
                    for (int k = i + 1; k < n; k++) {
                        if (count[k] != 0) {
                            ans[3] = (i + k) / 2.0;
                            break;
                        }
                    }
                    break;
                }
            }
        } else {
            int cur = 0;
            for (int i = 0; i < n; i++) {
                cur += count[i];
                if (cur >= size / 2 + 1) {
                    ans[3] = i;
                    break;
                }
            }
        }
        // mode
        int maxCount = 0;
        int mode = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxCount) {
                mode = i;
                maxCount = count[i];
            }
        }
        ans[4] = mode;
        return ans;
    }
}