class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<Integer, List<String>> list = new HashMap<>();
        int sum = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) 
            map.put(list1[i], i);
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int key = map.get(list2[i]) + i;
                if (key <= sum) {
                    if (!list.containsKey(key))
                        list.put(key, new ArrayList<>());
                    list.get(key).add(list2[i]);
                    sum = key;
                }
            }
        }
        List<String> list3 = list.get(sum);
        String[] result = new String[list3.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = list3.get(i);
        
        return result;
    }
}
