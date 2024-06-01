class Leaderboard {
    private Map<Integer, Integer> scores;

    public Leaderboard() {
        scores = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
    }
    
    public int top(int K) {
        List<Integer> list = new ArrayList<>(scores.values());
        Collections.sort(list, (a, b) -> b - a);
        int sum = 0;
        for (int i = 0; i < K; i++)
            sum += list.get(i);
        return sum;
    }
    
    public void reset(int playerId) {
        scores.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */