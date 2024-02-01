class Solution {
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                    int w = i - stack.peek() - 1;
                    ans += h * w;
                }
            }
            stack.push(i);
        }
        return ans;
    }
}