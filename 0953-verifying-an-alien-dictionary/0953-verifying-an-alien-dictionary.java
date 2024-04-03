class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        int len = 0;
        for (String word : words)
            len = Math.max(len, word.length());
        for (int i = 0; i < words.length - 1; i++) {
            int cur = -1, next = -1;
            for (int j = 0; j < Math.max(words[i].length(), words[i + 1].length()); j++) {
                if (j < words[i].length())
                    cur = map.get(words[i].charAt(j));
                else
                    cur = -1;
                if (j < words[i + 1].length())
                    next = map.get(words[i + 1].charAt(j));
                else
                    next = -1;
                if (cur > next)
                    return false;
                if (cur < next)
                    break;
            }
        }
        return true;
    }
}