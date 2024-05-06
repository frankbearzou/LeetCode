class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        long count = 0;
        int n = nums1.length;
        for (int i = 0; i < n; i++)
            nums1[i] -= nums2[i];
        Arrays.sort(nums1);
        for (int i = 0; i < n - 1; i++) {
            int l = i + 1, r = n - 1;
            while (l <= r) {
                int m = l + (r - l) / 2;
                int sum = nums1[i] + nums1[m];
                if (sum <= 0)
                    l = m + 1;
                else
                    r = m - 1;
            }
            count += n - l;
        }
        return count;
    }
}