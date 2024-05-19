class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long res = 0;
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            res += nums[i];
            arr[i] = (nums[i] ^ k) - nums[i];
        }
        Arrays.sort(arr);
        for (int i = n - 1; i >= 0; i -= 2) {
            if (i == 0)
                break;
            long sum = arr[i] + arr[i - 1];
            if (sum > 0)
                res += sum;
        }
        return res;
    }
}