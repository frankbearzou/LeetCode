class Solution {
    public long findScore(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], i};
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            else
                return a[0] - b[0];
        });
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (marked[arr[i][1]])
                continue;
            ans += arr[i][0];
            int index = arr[i][1];
            marked[index] = true;
            if (index > 0) {
                marked[index - 1] = true;
            }
            if (index + 1 < n) {
                marked[index + 1] = true;
            }
        }
        return ans;
    }
}