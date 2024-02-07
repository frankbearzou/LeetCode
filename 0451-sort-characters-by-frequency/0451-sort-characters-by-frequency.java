class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (var entry : map.entrySet()) {
            queue.offer(entry);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            var entry = queue.poll();
            char c = entry.getKey();
            int count = entry.getValue();
            while (count-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}