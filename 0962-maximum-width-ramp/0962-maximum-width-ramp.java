class Solution {
    public int maxWidthRamp(int[] nums) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()])
                stack.push(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                ans = Math.max(ans, i - stack.peek());
                stack.pop();
            }
        }
        return ans;
    }
}