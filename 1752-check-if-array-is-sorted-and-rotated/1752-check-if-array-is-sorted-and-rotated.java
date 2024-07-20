class Solution {
    public boolean check(int[] nums) {
        boolean decreased = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (decreased)
                    return false;
                decreased = true;
            }
        }
        if (decreased && nums[0] < nums[nums.length - 1])
            return false;
        return true;
    }
}