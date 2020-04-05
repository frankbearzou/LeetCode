class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null)
            return -1;
        if (nums.length == 1)
            return 0;
        
        // This solution fit all input values, I ignore range limit to add some complexities.
        int biggest, biggestIndex, bigger;
        if (nums[0] >= nums[1]) {
            biggest = nums[0];
            biggestIndex = 0;
            bigger = nums[1];
        } else {
            biggest = nums[1];
            biggestIndex = 1;
            bigger = nums[0];
        }
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > bigger) {
                bigger = nums[i];
            }
            if (bigger > biggest) {
                int temp = biggest;
                biggest = bigger;
                bigger = temp;
                
                biggestIndex = i;
            }
        }
        
        if (bigger * 2 <= biggest)
            return biggestIndex;
        else
            return -1;
    }
}
