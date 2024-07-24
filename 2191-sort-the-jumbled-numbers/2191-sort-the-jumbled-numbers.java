class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[][] map = new int[n][2];
        for (int i = 0; i < n; i++) {
            map[i][0] = nums[i];
            if (nums[i] == 0) {
                map[i][1] = mapping[0];
            } else {
                map[i][1] = get(nums[i], mapping);
            }
        }
        Arrays.sort(map, (a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < n; i++) {
            ans[i] = map[i][0];
        }
        return ans;
    }

    int get(int num, int[] mapping) {
        int ans = 0;
        int k = 1;
        while (num > 0) {
            ans = ans + mapping[num % 10] * k;
            num /= 10;
            k *= 10;
        }
        return ans;
    }
}