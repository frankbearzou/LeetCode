class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums)
            queue.add(num);
        long ans = 0;
        for (int i = 0; i < k; i++) {
            int val = queue.remove();
            ans += val;
            val = (int)Math.ceil(1.0 * val / 3);
            queue.add(val);
        }
        return ans;
    }
}