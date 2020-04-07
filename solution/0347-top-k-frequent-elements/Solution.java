class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> mapV = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (!mapV.containsKey(entry.getValue())) {
                mapV.put(entry.getValue(), new ArrayList<>());
            }
            mapV.get(entry.getValue()).add(entry.getKey());
            set.add(entry.getValue());
        }
        list.addAll(set);
        list.sort(Collections.reverseOrder());

        for (int i = 0; i < k && result.size() < k; i++) {
            List<Integer> keys = mapV.get(list.get(i));
            result.addAll(keys);
            
        }
        
        return result.subList(0, k);
    }
}
