class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = total / 2;
        int count = 0;
        int i = 0, j = 0;
        int prev = 0, cur = 0;
        while (count <= half) {
            prev = cur;
            if (i == m) {
                cur = nums2[j];
                j++;
            } else if (j == n) {
                cur = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                cur = nums1[i];
                i++;
            } else {
                cur = nums2[j];
                j++;
            }
            count++;
        }
        if (total % 2 == 0) {
            return (prev + cur) / 2.0;
        } else {
            return cur;
        }
    }
}