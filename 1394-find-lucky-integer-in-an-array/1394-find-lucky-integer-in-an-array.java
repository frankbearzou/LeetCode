class Solution {
    public int findLucky(int[] arr) {
        int max = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (var entry : map.entrySet()) {
            if (entry.getKey() == entry.getValue())
                max = Math.max(max, entry.getKey());
        }
        return max;
    }
}