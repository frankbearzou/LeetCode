class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> ans = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String str = s.substring(i, i + 10);
            if (set.contains(str)) {
                ans.add(str);
            } else {
                set.add(str);
            }
        }
        return new ArrayList<>(ans);
    }
}