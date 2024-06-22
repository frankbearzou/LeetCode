class Solution {
    public int findMaxLength(int[] nums) {
        int count = 0;
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(prefix)) {
                count = Math.max(count, i - map.get(prefix));
            } else {
                map.put(prefix, i);
            }
        }
        return count;
    }
}