class TimeMap {
    private Map<String, List<Pair<String, Integer>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> list = map.get(key);
        if (list == null)
            return "";
        int l = 0, r = list.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (list.get(m).getValue() <= timestamp)
                l = m + 1;
            else
                r = m;
        }
        if (r == 0)
            return "";
        return list.get(r - 1).getKey();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */