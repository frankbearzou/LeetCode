class Solution {
    public int[] numberOfPairs(int[] nums) {
        int pair = 0, single = 0;
        int[] map = new int[101];
        for (int num : nums) {
            map[num]++;
        }
        for (int num : map) {
            if (num != 0) {
                pair += num / 2;
                single += num & 1;
            }
        }
        return new int[]{pair, single};
    }
}