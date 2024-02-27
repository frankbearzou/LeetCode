class Solution {
    public int mostFrequentEven(int[] nums) {
        int max = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                int count = map.getOrDefault(num, 0) + 1;
                map.put(num, count);
                max = Math.max(max, count);
            }
        }
        for (var entry : map.entrySet()) {
            if (entry.getValue() == max) {
                return entry.getKey();
            }
        }
        return -1;
    }
}