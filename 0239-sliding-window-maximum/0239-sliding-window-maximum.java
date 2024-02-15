class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int N = nums.length;
        int[] ans = new int[N - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i - k + 1 >= 0) {
                ans[i - k + 1] = nums[deque.peek()];
            }
        }
        return ans;
    }
}