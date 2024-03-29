class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            map.putIfAbsent(s, new ArrayList());
            map.get(s).add(str);
        }
        return new ArrayList(map.values());
    }
}