class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int[] log : logs) {
            map.putIfAbsent(log[0], new HashSet());
            map.get(log[0]).add(log[1]);
        }
        for (var entry : map.entrySet()) {
            int size = entry.getValue().size();
            map2.put(size, map2.getOrDefault(size, 0) + 1);
        }
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = map2.getOrDefault(i + 1, 0);
        }
        return arr;
    }
}