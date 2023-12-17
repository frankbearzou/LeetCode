class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // out of bound
            while (!deque.isEmpty() && i - k >= deque.peek())
                deque.poll();
            // greater than last
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()])
                deque.pollLast();
            deque.offer(i);
            if (i >= k - 1)
                ans[index++] = nums[deque.peek()];
        }
        return ans;
    }
}