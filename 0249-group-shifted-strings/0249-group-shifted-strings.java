class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = getKey(s);
            map.putIfAbsent(key, new ArrayList());
            map.get(key).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for (var values : map.values()) {
            res.add(values);
        }
        return res;
    }
    
    String getKey(String s) {
        StringBuilder res = new StringBuilder();
        int diff = s.charAt(0) - 'a';
        for (char c : s.toCharArray()) {
            res.append((char)((c - diff + 26) % 26 + 'a'));
        }
        return res.toString();
    }
}