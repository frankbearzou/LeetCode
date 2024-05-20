class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] arr = new int[60];
        for (int t : time) {
            if (t % 60 == 0) {
                res += arr[0];
            } else {
                res += arr[60 - t % 60];
            }
            arr[t % 60]++;
        }
        return res;
    }
}