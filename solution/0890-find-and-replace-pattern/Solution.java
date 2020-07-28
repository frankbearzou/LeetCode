class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int[] p = p(pattern);
        
        for (String word : words) {
            if (Arrays.equals(p, p(word)))
                ans.add(word);
        }
        
        return ans;
    }
    
    private int[] p(String word) {
        Map<Character, Integer> map = new HashMap<>();
        int[] arr = new int[word.length()];
        
        for (int i = 0; i < word.length(); i++) {
            map.putIfAbsent(word.charAt(i), map.size());
            arr[i] = map.get(word.charAt(i));
        }
        
        return arr;
    }
}
