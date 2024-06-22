class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int oddCount = 0;
        Map<Integer, Integer> frequency = new HashMap<>();
        frequency.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                oddCount++;
            }
            if (frequency.containsKey(oddCount - k)) {
                count += frequency.get(oddCount - k);
            }
            frequency.put(oddCount, frequency.getOrDefault(oddCount, 0) + 1);
        }
        return count;
    }
}