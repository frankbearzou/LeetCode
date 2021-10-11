class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int max = 0;
        for (int num : nums) {
            if (set.remove(num)) {
                int count = 1;
                int left = num - 1, right = num + 1;
                while (set.remove(left)) {
                    left--;
                    count++;
                }
                while (set.remove(right)) {
                    right++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
