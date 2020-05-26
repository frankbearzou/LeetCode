class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0;
        int val = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                val--;
            else
                val++;
            if (!map.containsKey(val)) {
                map.put(val, i);
            } else {
                max = Math.max(max, i - map.get(val));
            }
        }
        
        return max;
    }
}
