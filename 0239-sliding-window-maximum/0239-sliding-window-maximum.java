class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0, r = 0, index = 0;
        int[] ans = new int[nums.length - k + 1];
        // decreasing order
        Deque<Integer> deque = new ArrayDeque<>();
        while (r < nums.length) {
            // remove smaller value in deque
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r]) {
                deque.removeLast();
            }
            deque.addLast(r);
            // remove out off bound index
            if (l > deque.peekFirst()) {
                deque.removeFirst();
            }
            if (r + 1 >= k) {
                ans[index++] = nums[deque.peekFirst()];
                l++;
            }
            r++;
        }
        return ans;
    }
}