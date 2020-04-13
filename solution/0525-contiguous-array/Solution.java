class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, max = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;
    }
}
