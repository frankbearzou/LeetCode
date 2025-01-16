class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        boolean m = nums1.length % 2 == 0;
        boolean n = nums2.length % 2 == 0;
        if (m && n)
            return 0;
        int x = 0;
        for (int num : nums1)
            x ^= num;
        if (m)
            return x;
        int y = 0;
        for (int num : nums2)
            y ^= num;
        if (n)
            return y;
        return x ^ y;
    }
}