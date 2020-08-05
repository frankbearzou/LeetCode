class WordDictionary {
    private Map<Integer, List<String>> map;

    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int index = word.length();
        map.putIfAbsent(index, new ArrayList<String>());
        map.get(index).add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int index = word.length();
        List<String> list = map.get(index);
        if (list == null)
            return false;
        if (!word.contains(".")) {
            return list.contains(word);
        } else {
            for (String s : list) {
                boolean same = true;
                for (int i = 0; i < s.length(); i++) {
                    if (word.charAt(i) != '.' && word.charAt(i) != s.charAt(i)) {
                        same = false;
                        break;
                    }
                }
                if (same)
                    return true;
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
