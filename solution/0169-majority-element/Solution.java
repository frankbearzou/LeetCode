class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                int value = map.get(num) + 1;
                map.put(num, value);
                if (value > nums.length / 2)
                    return num;
            } else {
                map.put(num, 1);
            }
        }
        return nums[0];
    }
}
