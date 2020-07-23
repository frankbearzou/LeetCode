class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        String from = paths.get(0).get(0);
        
        while (map.containsKey(from)) {
            from = map.get(from);
        }
        
        return from;
    }
}
