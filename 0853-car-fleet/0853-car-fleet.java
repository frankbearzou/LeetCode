class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int n = position.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = position[i];
            arr[i][1] = speed[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int i = n - 1; i >= 0; i--) {
            double cur = 1.0 * (target - arr[i][0]) / arr[i][1];
            if (stack.isEmpty() || cur > stack.peek())
                stack.push(cur);
        }
        return stack.size();
    }
}