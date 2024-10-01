class Solution {
    public int largestUniqueNumber(int[] nums) {
        int[] arr = new int[1001];
        for (int i : nums)
            arr[i]++;
        for (int i = 1000; i >= 0; i--) {
            if (arr[i] == 1)
                return i;
        }
        return -1;
    }
}