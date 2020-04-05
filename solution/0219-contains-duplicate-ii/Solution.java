class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < k && i < nums.length; i++) {
            if (!set.add(nums[i]))
                return true;
        }
        for (int i = 0; i < nums.length - k; i++) {
            if (!set.add(nums[i + k]))
                return true;
            set.remove(nums[i]);
        }
        return false;
    }
}
