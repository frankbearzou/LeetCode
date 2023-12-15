class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (map.containsKey(t)) {
                int index = map.get(t);
                ans[0] = index;
                ans[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}