class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        String ans = "";
        Set<String> ban = new HashSet<>();
        for (String s : banned) {
            ban.add(s);
        }
        paragraph += ".";
        StringBuilder cleanWord = new StringBuilder();
        for (char c : paragraph.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z')
                cleanWord.append(c);
            else if (cleanWord.length() > 0) {
                String finalWord = cleanWord.toString();
                if (!ban.contains(finalWord)) {
                    int count = map.getOrDefault(finalWord, 0) + 1;
                    if (count > max) {
                        max = count;
                        ans = finalWord;
                    }
                    map.put(finalWord, count);
                }
                
                cleanWord = new StringBuilder();
            }
        }
        
        return ans;
    }
}
