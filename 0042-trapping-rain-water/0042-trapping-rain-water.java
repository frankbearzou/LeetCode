class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int[] lmax = new int[height.length];
        lmax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            lmax[i] = Math.max(height[i], lmax[i - 1]);
        }
        int[] rmax = new int[height.length];
        rmax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rmax[i] = Math.max(height[i], rmax[i + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return ans;
    }
}