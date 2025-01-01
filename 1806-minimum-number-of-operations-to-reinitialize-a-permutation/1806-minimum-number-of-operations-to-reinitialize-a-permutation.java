class Solution {
    public int reinitializePermutation(int n) {
        int count = 0;
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        while (true) {
            count++;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            boolean same = true;
            for (int i = 0; i < n; i++) {
                if (arr[i] != i) {
                    same = false;
                    break;
                }
            }
            if (same)
                break;
            perm = arr;
        }
        return count;
    }
}