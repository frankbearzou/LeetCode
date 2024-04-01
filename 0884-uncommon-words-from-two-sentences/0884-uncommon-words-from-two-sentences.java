class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] split1 = s1.split(" ");
        String[] split2 = s2.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String s : split1) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : split2) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (var entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }
}