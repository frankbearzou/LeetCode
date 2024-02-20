class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (1 + n) * n / 2;
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        return sum - s;
    }
}