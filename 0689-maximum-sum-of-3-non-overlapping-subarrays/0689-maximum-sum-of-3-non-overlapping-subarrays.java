class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        // Get the length of input array
        int n = nums.length;
        
        // Calculate sliding window sums for windows of size k
        int[] sums = new int[n - k + 1];  // Will store sum of each k-sized window
        int sum = 0;
        
        // Calculate sum of first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        sums[0] = sum;
        
        // Calculate sums for rest of the windows using sliding window
        for (int i = k; i < n; i++) {
            sum = sum + nums[i] - nums[i - k];
            sums[i - k + 1] = sum;
        }
        
        // DP arrays to store the best single window and its index from left and right
        int[] leftMax = new int[n - k + 1];  // Max sum on left side
        int[] leftIdx = new int[n - k + 1];  // Index giving max sum on left side
        
        // Initialize first values
        leftMax[0] = sums[0];
        leftIdx[0] = 0;
        
        // Fill leftMax and leftIdx arrays
        for (int i = 1; i < n - k + 1; i++) {
            if (sums[i] > leftMax[i - 1]) {
                leftMax[i] = sums[i];
                leftIdx[i] = i;
            } else {
                leftMax[i] = leftMax[i - 1];
                leftIdx[i] = leftIdx[i - 1];
            }
        }
        
        // DP arrays for right side
        int[] rightMax = new int[n - k + 1];  // Max sum on right side
        int[] rightIdx = new int[n - k + 1];  // Index giving max sum on right side
        
        // Initialize last values
        rightMax[n - k] = sums[n - k];
        rightIdx[n - k] = n - k;
        
        // Fill rightMax and rightIdx arrays from right to left
        for (int i = n - k - 1; i >= 0; i--) {
            if (sums[i] >= rightMax[i + 1]) {  // Use >= to get lexicographically smallest
                rightMax[i] = sums[i];
                rightIdx[i] = i;
            } else {
                rightMax[i] = rightMax[i + 1];
                rightIdx[i] = rightIdx[i + 1];
            }
        }
        
        // Find the maximum sum possible with three windows
        int maxTotal = 0;
        int[] result = new int[3];  // Will store the three indices
        
        // Try each possible position for middle window
        for (int i = k; i <= n - 2 * k; i++) {
            int left = leftMax[i - k];  // Best sum on left of current position
            int middle = sums[i];       // Sum at current position
            int right = rightMax[i + k]; // Best sum on right of current position
            
            if (left + middle + right > maxTotal) {
                maxTotal = left + middle + right;
                result[0] = leftIdx[i - k];  // Left window index
                result[1] = i;               // Middle window index
                result[2] = rightIdx[i + k]; // Right window index
            }
        }
        
        return result;
    }
}