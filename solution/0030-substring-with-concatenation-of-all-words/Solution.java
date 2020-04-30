class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n = words.length;
        if (n == 0)
            return res;
        int len = words[0].length();

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);

        for (int i = 0; i <= s.length() - len * n; i++) {
            HashMap<String, Integer> wordMap = new HashMap<>();
            for (int j = i; j < i + len * n; j += len) {
                String word = s.substring(j, j + len);
                if (!map.containsKey(word))
                    break;
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
                if (wordMap.get(word) > map.get(word))
                    break;
            }
            if (map.equals(wordMap))
                res.add(i);
        }

        return res;
    }
}
