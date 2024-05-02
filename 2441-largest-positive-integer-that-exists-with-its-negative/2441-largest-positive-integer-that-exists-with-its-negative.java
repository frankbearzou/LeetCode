class Solution {
    public int findMaxK(int[] nums) {
        int max = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < 0) {
                set.add(num);
            }
        }
        for (int num : nums) {
            if (num > 0 && set.contains(-num) && num > max)
                max = num;
        }
        return max;
    }
}