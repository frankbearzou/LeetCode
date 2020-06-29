class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < groupSizes.length; i++) {
            map.putIfAbsent(groupSizes[i], new LinkedList<Integer>());
            map.get(groupSizes[i]).add(i);
        }
        
        for (Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            LinkedList<Integer> values = entry.getValue();
            int size = values.size() / key;
            for (int i = 0; i < size; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < key; j++) {
                    list.add(values.pollFirst());
                }
                ans.add(list);
            }
        }
        
        return ans;
    }
}
