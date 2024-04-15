class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int res = -1;
        for (var entry : map.entrySet()) {
            if (entry.getValue() == 1)
                res = Math.max(res, entry.getKey());
        }
        return res;
    }
}