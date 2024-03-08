class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] map = new int[101];
        int max = 0;
        for (int num : nums) {
            map[num]++;
            max = Math.max(max, map[num]);
        }
        int sum = 0;
        for (int num : map) {
            if (num == max) {
                sum += num;
            }
        }
        return sum;
    }
}