class Solution {
    int ans = 0;
    int[] nums;
    int max;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        for (int num : nums)
            max |= num;
        backtracking(0, new ArrayList());
        return ans;
    }

    void backtracking(int index, List<Integer> path) {
        int cur = 0;
        for (int v : path)
            cur |= v;
        if (cur == max)
            ans++;
        if (index > nums.length)
            return;
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(i + 1, path);
            path.removeLast();
        }
    }
}