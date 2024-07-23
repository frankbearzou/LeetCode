class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Queue<Integer>> map = new TreeMap<>();
        for (var entry : freq.entrySet()) {
            map.putIfAbsent(entry.getValue(), new PriorityQueue<Integer>((a, b) -> b - a));
            map.get(entry.getValue()).add(entry.getKey());
        }
        int[] ans = new int[nums.length];
        int i = 0;
        while (i < nums.length) {
            for (var entry : map.entrySet()) {
                int times = entry.getKey();
                Queue<Integer> q = entry.getValue();
                while (!q.isEmpty()) {
                    int value = q.poll();
                    for (int j = 0; j < times; j++) {
                    ans[i++] = value;
                }
                }
                
            }
        }
        return ans;
    }
}