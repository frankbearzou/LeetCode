class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        for (Map.Entry entry : map.entrySet()) {
            queue.offer((Character)entry.getKey());
        }

        while (!queue.isEmpty()) {
            Character key = queue.poll();
            Integer val = map.get(key);
            for (int i = 0; i < val; i++)
                sb.append(key);
        }

        return sb.toString();
    }
}
