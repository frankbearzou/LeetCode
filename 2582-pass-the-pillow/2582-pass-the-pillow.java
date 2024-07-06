class Solution {
    public int passThePillow(int n, int time) {
        int[] arr = new int[2 * n - 1];
        for (int i = 0; i <= arr.length / 2; i++) {
            arr[i] = arr[arr.length - 1 - i] = i + 1;
        }
        return arr[time % (arr.length - 1)];
    }
}