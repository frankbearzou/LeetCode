class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums == null || nums.length == 0)
            return ans;
        
        int lo = 0, hi = nums.length - 1, mid = 0;
        
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                break;
            if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        
        if (nums[mid] != target)
            return new int[]{-1, -1};
        
        for (int i = mid; i >= 0; i--) {
            if (nums[i] == target)
                lo = i;
        }
        
        for (int i = mid; i < nums.length; i++) {
            if (nums[i] == target)
                hi = i;
        }
        
        return new int[]{lo, hi};
    }
}
