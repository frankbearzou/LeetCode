class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr = new int[51];
        for (int i = left; i <= right; i++) {
            arr[i] = 1;
        }
        for (int[] range : ranges) {
            for (int i = range[0]; i <= range[1]; i++) {
                arr[i]--;
            }
        }
        for (int i = left; i <= right; i++) {
            if (arr[i] > 0)
                return false;
        }
        return true;
    }
}