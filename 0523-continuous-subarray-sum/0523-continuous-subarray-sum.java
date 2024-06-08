class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i < prefix.length; i++) {
            set.add(prefix[i - 2] % k);
            if (set.contains(prefix[i] % k))
                return true;
        }
        return false;
    }
}