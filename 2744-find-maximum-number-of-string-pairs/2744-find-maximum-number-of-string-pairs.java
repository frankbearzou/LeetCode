class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        Set<String> set = new HashSet<>();
        for (String word : words) {
            String reversed = "" + word.charAt(1) + word.charAt(0);
            if (set.contains(reversed)) {
                count++;
            }
            set.add(word);
        }
        return count;
    }
}