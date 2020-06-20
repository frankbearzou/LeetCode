class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            // remove out of range
            if (!deque.isEmpty() && i - deque.peek() > k - 1)
                deque.poll();

            // remove smaller number
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.pollLast();

            deque.offer(i);
            if (i >= k - 1)
                ans[idx++] = nums[deque.peek()];
        }

        return ans;
    }
}
