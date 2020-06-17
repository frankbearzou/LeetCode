class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
        }
        
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            int curEnd = map.get(S.charAt(i));
            if (curEnd > end) {
                end = curEnd;
            } else if (i == end) {
                ans.add(end - start + 1);
                start = i + 1;
                end = i + 1;
            }
        }
        
        return ans;
    }
}
