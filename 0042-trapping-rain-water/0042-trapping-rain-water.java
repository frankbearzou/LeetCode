class Solution {
    public int trap(int[] height) {
        int res = 0;
        int preMax = 0, postMax = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            preMax = Math.max(preMax, height[l]);
            postMax = Math.max(postMax, height[r]);
            if (preMax < postMax) {
                res += preMax - height[l];
                l++;
            } else {
                res += postMax - height[r];
                r--;
            }
        }
        return res;
    }
}