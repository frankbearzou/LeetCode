class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray())
            set.add(c);
        for (String word : words) {
            boolean b = true;
            for (char c : word.toCharArray()) {
                if (!set.contains(c)) {
                    b = false;
                    break;
                }
            }
            if (b)
                count++;
        }
        return count;
    }
}