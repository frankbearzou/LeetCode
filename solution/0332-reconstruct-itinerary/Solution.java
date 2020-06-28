class Solution {
    List<String> ans = new ArrayList<>();
    Map<String, PriorityQueue<String>> flights = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            flights.putIfAbsent(from, new PriorityQueue<String>());
            flights.get(from).add(to);
        }
        
        dfs("JFK");
        
        return ans;
    }
    
    private void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        ans.add(0, departure);
    }
}
