class Solution {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int first = -1, last = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                first = i;
            else if (nums[i] == n)
                last = i;
        }
        int dis = first + n - last - 1;
        if (first > last)
            dis -= 1;
        return dis;
    }
}