class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                queue.add(sum);
                if (queue.size() > right) {
                    queue.remove();
                }
            }
        }
        int ans = 0;
        int mod = (int)1e9 + 7;
        for (int i = left; i <= right; i++) {
            ans = (ans + queue.remove()) % mod;
        }
        return ans;
    }
}