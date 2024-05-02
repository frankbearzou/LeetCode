class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.pollLast();
            deque.offer(i);
            if (deque.peek() == i - k)
                deque.poll();
            if (i - k + 1 >= 0)
                res[i - k + 1] = nums[deque.peek()];
        }
        return res;
    }
}