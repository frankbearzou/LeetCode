class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int begin = 0, end = 0;
        int sum = nums[0];
        int dis = nums.length + 1;
        while (begin < nums.length && end < nums.length) {
            if (sum >= s) {
                if (end - begin + 1 < dis)
                    dis = end - begin + 1;
                sum -= nums[begin];
                begin++;
            } else {
                if (end < nums.length - 1) {
                    end++;
                    sum += nums[end];
                } else {
                    break;
                }
            }
        }
        if (dis > nums.length)
            return 0;
        return dis;
    }
}
