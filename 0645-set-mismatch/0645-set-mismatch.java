class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicate = 0, missing = 0;
        int[] map = new int[nums.length + 1];
        for (int num : nums) {
            map[num]++;
        }
        for (int i = 1; i < map.length; i++) {
            if (map[i] == 2)
                duplicate = i;
            if (map[i] == 0)
                missing = i;
        }
        return new int[]{duplicate, missing};
    }
}