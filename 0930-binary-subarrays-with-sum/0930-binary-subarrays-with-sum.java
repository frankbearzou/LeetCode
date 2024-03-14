class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int total = 0;
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            prefix += num;
            if (prefix == goal)
                total++;
            if (map.containsKey(prefix - goal))
                total += map.get(prefix -goal);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return total;
    }
}