class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0, lessThan = 0;
        for (int num : nums) {
            if (num == target)
                count++;
            else if (num < target)
                lessThan++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(lessThan++);
        }
        return list;
    }
}