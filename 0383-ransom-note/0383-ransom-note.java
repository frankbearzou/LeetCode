class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c : ransomNote.toCharArray()) {
            map[(int)(c - 'a')]++;
        }
        for (char c : magazine.toCharArray()) {
            map[(int)(c - 'a')]--;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                return false;
            }
        }
        return true;
    }
}