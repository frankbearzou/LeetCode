class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        for (int i : nums) {
            Set<Integer> set = new HashSet<>(dp);
            for (int v : dp) {
                if (v + i == target)
                    return true;
                set.add(v + i);
            }
            dp = set;
        }
        return false;
    }
}