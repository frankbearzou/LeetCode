class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length())
                return b.length() - a.length();
            else
                return a.compareTo(b);
        });
        Set<String> set = new HashSet<>();
        for (String word : words)
            set.add(word);
        for (String word : words) {
            boolean found = true;
            for (int i = word.length() - 1; i > 0; i--) {
                if (!set.contains(word.substring(0, i))) {
                    found = false;
                    break;
                }
            }
            if (found)
                return word;
        }
        return "";
    }
}