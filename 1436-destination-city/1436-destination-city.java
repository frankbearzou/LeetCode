class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
        }
        String from = paths.get(0).get(0);
        while (map.get(from) != null) {
            from = map.get(from);
        }
        return from;
    }
}