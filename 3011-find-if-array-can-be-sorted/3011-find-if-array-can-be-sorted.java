class Solution {
    public boolean canSortArray(int[] nums) {
        if (isSorted(nums))
            return true;
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[]{nums[i], bits(nums[i])};
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i - 1][1] > arr[i][1])
                return false;
        }
        return true;
    }

    boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i])
                return false;
        }
        return true;
    }

    int bits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}