class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        int freq = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != freq)
                return false;
        }
        return true;
    }
}