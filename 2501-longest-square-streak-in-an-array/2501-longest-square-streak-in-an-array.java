class Solution {
    public int longestSquareStreak(int[] nums) {
        int ans = 0;
        Set<Long> set = new HashSet<>();
        Set<Long> visited = new HashSet<>();
        for (int num : nums)
            set.add(1L * num);
        
        for (int num : nums) {
            long val = 1L * num;
            if (visited.contains(val))
                continue;
            visited.add(val);
            int count = 1;
            while (set.contains(val * val)) {
                count++;
                val = val * val;
                visited.add(val);
            }
            ans = Math.max(ans, count);
        }
        if (ans <= 1)
            return -1;
        return ans;
    }
}