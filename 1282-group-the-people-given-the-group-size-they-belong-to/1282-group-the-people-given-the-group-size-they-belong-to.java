class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = groupSizes.length;
        for (int i = 0; i < n; i++) {
            int group = groupSizes[i];
            map.putIfAbsent(group, new ArrayList());
            map.get(group).add(i);
            if (map.get(group).size() == group) {
                res.add(map.get(group));
                map.remove(group);
            }
        }
        return res;
    }
}