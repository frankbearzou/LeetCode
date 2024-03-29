class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Queue<Pair<String, Integer>> queue = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < n; i++) {
            queue.offer(new Pair(names[i], heights[i]));
        }
        for (int i = 0; i < n; i++) {
            names[i] = queue.poll().getKey();
        }
        return names;
    }
}