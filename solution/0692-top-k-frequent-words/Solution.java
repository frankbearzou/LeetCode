class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        LinkedList<String> ans = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue()))
                return b.getKey().compareTo(a.getKey());
            return a.getValue().compareTo(b.getValue());
        });
        
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        
        while (!minHeap.isEmpty()) {
            ans.addFirst(minHeap.poll().getKey());
        }
        
        return ans;
    }
}
