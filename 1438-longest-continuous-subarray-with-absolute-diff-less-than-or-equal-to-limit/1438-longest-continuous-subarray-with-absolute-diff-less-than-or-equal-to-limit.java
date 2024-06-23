class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int res = 0;
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while (!max.isEmpty() && nums[max.peekLast()] <= nums[r])
                max.pollLast();
            max.offer(r);
            while (!min.isEmpty() && nums[min.peekLast()] >= nums[r])
                min.pollLast();
            min.offer(r);
            while (!max.isEmpty() && !min.isEmpty() &&
                nums[max.peekFirst()] - nums[min.peekFirst()] > limit) {
                l++;
                if (max.peekFirst() < l)
                    max.pollFirst();
                if (min.peekFirst() < l)
                    min.pollFirst();
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}