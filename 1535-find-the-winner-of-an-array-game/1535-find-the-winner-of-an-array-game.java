class Solution {
    public int getWinner(int[] arr, int k) {
        int cur = arr[0], win = 0;
        for (int i = 1; i < arr.length; i++) {
            if (cur < arr[i]) {
                cur = arr[i];
                win = 0;
            }
            if (++win == k) {
                return cur;
            }
        }
        return cur;
    }
}