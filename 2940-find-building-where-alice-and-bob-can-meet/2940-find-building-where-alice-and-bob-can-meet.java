class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        int q = queries.length;
        int[] ans = new int[q];
        Stack<Integer> stack = new Stack<>();
        int[] next = new int[n];
        Arrays.fill(next, -1);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                next[stack.pop()] = i;
            }
            stack.push(i);
        }
        for (int i = 0; i < q; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            if (a == b) {
                ans[i] = b;
                continue;
            }
            if (heights[a] < heights[b]) {
                ans[i] = b;
                continue;
            }
            int meet = -1;
            int cur = b;
            int max = Math.max(heights[a], heights[b]);
            while (cur != -1) {
                if (heights[cur] > max) {
                    meet = cur;
                    break;
                }
                cur = next[cur];
            }
            ans[i] = meet;
        }
        return ans;
    }
}