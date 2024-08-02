class Solution {
    public int minSwaps(int[] nums) {
        int ans = 0;
        int countOne = 0;
        for (int num : nums) {
            countOne += num;
        }
        int n = nums.length;
        int[] arr = new int[n * 2];
        System.arraycopy(nums, 0, arr, 0, n);
        System.arraycopy(nums, 0, arr, n, n);
        int countZero = 0;
        for (int i = 0; i < countOne; i++) {
            if (arr[i] == 0)
                countZero++;
        }
        ans = countZero;
        for (int i = countOne; i < n * 2; i++) {
            if (arr[i] == 0)
                countZero++;
            if (arr[i - countOne] == 0)
                countZero--;
            ans = Math.min(ans, countZero);
        }
        return ans;
    }
}