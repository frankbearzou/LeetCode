class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winnerSet = new HashSet<>();
        Map<Integer, Integer> loserMap = new HashMap<>();
        PriorityQueue<Integer> winnerQueue = new PriorityQueue<>();
        PriorityQueue<Integer> loserQueue = new PriorityQueue<>();
        List<Integer> winnerList = new ArrayList<>();
        List<Integer> loserList = new ArrayList<>();
        for (int[] match : matches) {
            winnerSet.add(match[0]);
            loserMap.put(match[1], loserMap.getOrDefault(match[1], 0) + 1);
        }
        for (int win : winnerSet) {
            if (!loserMap.containsKey(win)) {
                winnerQueue.offer(win);
            }
        }
        for (var entry : loserMap.entrySet()) {
            if (entry.getValue() == 1) {
                loserQueue.offer(entry.getKey());
            }
        }
        while (!winnerQueue.isEmpty()) {
            winnerList.add(winnerQueue.poll());
        }
        while (!loserQueue.isEmpty()) {
            loserList.add(loserQueue.poll());
        }
        return List.of(winnerList, loserList);
    }
}