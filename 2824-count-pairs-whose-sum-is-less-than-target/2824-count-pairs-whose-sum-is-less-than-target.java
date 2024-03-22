class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int count = 0;
        Collections.sort(nums);
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int sum = nums.get(l) + nums.get(r);
            if (sum >= target) {
                r--;
            } else {
                count += r - l;
                l++;
            }
        }
        return count;
    }
}