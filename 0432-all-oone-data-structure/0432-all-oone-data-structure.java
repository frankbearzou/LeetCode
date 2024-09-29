class AllOne {
    private Map<String, Integer> map;
    private TreeMap<Integer, Set<String>> cntMap;

    public AllOne() {
        map = new HashMap<>();
        cntMap = new TreeMap<>();
    }
    
    public void inc(String key) {
        int count = map.getOrDefault(key, 0);
        map.put(key, count + 1);
        cntMap.putIfAbsent(count + 1, new HashSet());
        cntMap.get(count + 1).add(key);
        if (count > 0) {
            cntMap.get(count).remove(key);
            if (cntMap.get(count).isEmpty())
                cntMap.remove(count);
        }
    }
    
    public void dec(String key) {
        int count = map.get(key);
        cntMap.get(count).remove(key);
        if (cntMap.get(count).isEmpty())
            cntMap.remove(count);
        if (count == 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
            cntMap.putIfAbsent(count - 1, new HashSet());
            cntMap.get(count - 1).add(key);
        }
    }
    
    public String getMaxKey() {
        if (map.isEmpty())
            return "";
        int max = cntMap.floorKey(50000);
        return cntMap.get(max).iterator().next();
    }
    
    public String getMinKey() {
        if (map.isEmpty())
            return "";
        int min = cntMap.ceilingKey(0);System.out.println(min);
        return cntMap.get(min).iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */