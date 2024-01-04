class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (var v : map.values()) {
            if (v == 1) {
                return -1;
            } else {
                count += v / 3 + (v % 3 == 0 ? 0 : 1);
            }
        }
        return count;
    }
}