class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> list = new ArrayList<>();
        int val = 0;
        for (int i = 0; i < n; i++) {
            val = ((val << 1) | nums[i]) % 5;
            list.add((val % 5) == 0);
        }
        return list;
    }
}