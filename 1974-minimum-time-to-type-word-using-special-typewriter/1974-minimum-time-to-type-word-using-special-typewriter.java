class Solution {
    public int minTimeToType(String word) {
        int count = dis('a', word.charAt(0));
        for (int i = 0; i < word.length() - 1; i++) {
            count += dis(word.charAt(i), word.charAt(i + 1));
        }
        return count + word.length();
    }

    int dis(char a, char b) {
        int max = Math.max(a - 'a', b - 'a');
        int min = Math.min(a - 'a', b - 'a');
        return Math.min(max - min, min + 26 - max);
    }
}