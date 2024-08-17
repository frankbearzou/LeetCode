class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, map.get(s.charAt(i)));
            if (i == max) {
                list.add(i - start + 1);
                start = i + 1;
            }
        }
        return list;
    }
}