class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        for (int num : nums) {
            if (!set.contains(num - 1)) { // start of sequence
                int len = 0;
                while (set.contains(num + len))
                    len++;
                res = Math.max(res, len);
            }
        }
        return res;
    }
}