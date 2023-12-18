class Solution {
    public int maxProductDifference(int[] nums) {
        int largest = 0, secondLargest = 0, smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num >= largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
            if (num <= smallest) {
                secondSmallest = smallest;
                smallest = num;
            } else if (num < secondSmallest) {
                secondSmallest = num;
            }
        }
        return largest * secondLargest - smallest * secondSmallest;
    }
}