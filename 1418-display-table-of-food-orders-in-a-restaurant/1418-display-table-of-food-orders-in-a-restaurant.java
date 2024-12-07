class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans = new ArrayList<>();
        TreeSet<String> dish = new TreeSet<>();
        TreeMap<Integer, Map<String, Integer>> table = new TreeMap<>();
        for (List<String> order : orders) {
            int t = Integer.parseInt(order.get(1));
            String d = order.get(2);
            dish.add(d);
            table.putIfAbsent(t, new HashMap<>());
            table.get(t).put(d, table.get(t).getOrDefault(d, 0) + 1);
        }
        // header
        List<String> header = new ArrayList<>();
        header.add("Table");
        for (String d : dish) {
            header.add(d);
        }
        ans.add(header);
        for (var entry : table.entrySet()) {
            List<String> list = new ArrayList<>();
            int t = entry.getKey();
            list.add(String.valueOf(t));
            Map<String, Integer> map = entry.getValue();
            for (String d : dish) {
                list.add(String.valueOf(map.getOrDefault(d, 0)));
            }
            ans.add(list);
        }
        return ans;
    }
}