class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            Map<Character, Character> map = new HashMap<>();
            Map<Character, Character> map2 = new HashMap<>();
            boolean valid = true;
            for (int i = 0; i < word.length(); i++) {
                char a = word.charAt(i);
                char b = pattern.charAt(i);
                if (!map.containsKey(a) && !map2.containsKey(b)) {
                    map.put(a, b);
                    map2.put(b, a);
                } else if ((map.containsKey(a) && map.get(a) == b) && (map2.containsKey(b) && map2.get(b) == a)) {

                } else {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                res.add(word);
            }
        }
        return res;
    }
}