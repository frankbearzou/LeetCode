class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> path = new ArrayList<>();
        Map<String, Map<String, Integer>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.putIfAbsent(from, new TreeMap());
            Map<String, Integer> toMap = map.get(from);
            toMap.put(to, toMap.getOrDefault(to, 0) + 1);
        }
        path.add("JFK");
        dfs(map, path, tickets.size());
        return path;
    }

    boolean dfs(Map<String, Map<String, Integer>> map, List<String> path, int count) {
        if (path.size() == count + 1) {
            return true;
        }
        String last = path.get(path.size() - 1);
        if (!map.containsKey(last))
            return false;
        Map<String, Integer> toMap = map.get(last);
        for (var m : toMap.entrySet()) {
            String to = m.getKey();
            int i = m.getValue();
            if (i > 0) {
                map.get(last).put(to, i - 1);
                path.add(to);
                if (dfs(map, path, count))
                    return true;
                path.remove(path.size() - 1);
                map.get(last).put(to, i);
            }
        }
        return false;
    }
}