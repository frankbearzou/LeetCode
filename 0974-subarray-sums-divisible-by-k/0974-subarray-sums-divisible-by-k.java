class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, res = 0;
        int[] map = new int[k];
        map[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            int key = (sum % k + k) % k;
            res += map[key];
            map[key]++;
        }
        return res;
    }
}