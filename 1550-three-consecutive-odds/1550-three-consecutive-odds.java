class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            if (arr[i] % 2 == 0)
                continue;
            if (arr[i + 1] % 2 == 0) {
                i++;
                continue;
            }
            if (arr[i + 2] % 2 == 0) {
                i += 2;
                continue;
            }
            return true;
        }
        return false;
    }
}