class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N * 2; i++) {
            int t = nums[i % N];
            while (!stack.isEmpty() && t > nums[stack.peek() % N]) {
                ans[stack.peek()] = nums[i % N];
                stack.pop();
            }
            stack.push(i % N);
        }
        return ans;
    }
}