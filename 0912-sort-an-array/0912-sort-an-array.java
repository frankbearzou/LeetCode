class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    void sort(int[] nums, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            sort(nums, lo, mid);
            sort(nums, mid + 1, hi);
            merge(nums, lo, mid, hi);
        }
    }

    void merge(int[] nums, int lo, int mid, int hi) {
        int n1 = mid - lo + 1;
        int n2 = hi - mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            arr1[i] = nums[lo + i];
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = nums[mid + 1 + i];
        }
        int i = lo, j = 0, k = 0;
        while (j < n1 && k < n2) {
            if (arr1[j] <= arr2[k]) {
                nums[i++] = arr1[j++];
            } else {
                nums[i++] = arr2[k++];
            }
        }
        while (j < n1) {
            nums[i++] = arr1[j++];
        }
        while (k < n2) {
            nums[i++] = arr2[k++];
        }
    }
}