class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        int ans = 0;
        int cur = 0, next = 0;
        for (int i = 0; i < nums.length; i++) {
            next = Math.max(next, i + nums[i]);
            if (cur == i) {
                ans++;
                cur = next;
                if (next >= nums.length - 1)
                    break;
            }
        }
        return ans;
    }
}