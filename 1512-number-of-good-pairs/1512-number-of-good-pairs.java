class Solution {
    public int numIdenticalPairs(int[] nums) {
        int res = 0;
        int[] arr = new int[101];
        for (int num : nums)
            arr[num]++;
        for (int num : arr) {
            if (num == 2) {
                res += 1;
            } else if (num > 2) {
                res += num * (num - 1) / 2;
            }
        }
        return res;
    }
}