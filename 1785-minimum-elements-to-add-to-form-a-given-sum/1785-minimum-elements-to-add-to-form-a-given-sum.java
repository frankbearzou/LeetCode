class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        sum = goal - sum;
        sum = Math.abs(sum);
        int count = (int)(sum / limit);
        if (sum % limit != 0)
            count++;
        return count;
    }
}