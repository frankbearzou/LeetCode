class Solution {
    public int majorityElement(int[] nums) {
        int res = 0, count = 0;
        for (int n : nums) {
            if (count == 0) {
                res = n;
            }
            if (res == n) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
}