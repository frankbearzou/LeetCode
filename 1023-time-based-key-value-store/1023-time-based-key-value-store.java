class TimeMap {
    private Map<String, List<Object[]>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Object[]> values = map.getOrDefault(key, new ArrayList<Object[]>());
        values.add(new Object[]{value, timestamp});
        map.put(key, values);
    }
    
    public String get(String key, int timestamp) {
        List<Object[]> values = map.getOrDefault(key, new ArrayList<Object[]>());
        int l = 0, r = values.size() - 1;
        String ans = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            int t = (int)values.get(m)[1];
            String v = String.valueOf(values.get(m)[0]);
            if (t == timestamp) {
                return v;
            } else if (t < timestamp) {
                ans = v;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */