class Solution {
    public int sumOfUnique(int[] nums) {
        int sum = 0;
        int[] map = new int[101];
        for (int i : nums)
            map[i]++;
        for (int i = 0; i < 101; i++) {
            if (map[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}