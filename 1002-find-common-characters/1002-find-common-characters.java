class Solution {
    public List<String> commonChars(String[] words) {
        int[] pre = new int[26];
        int[] cur = new int[26];
        for (char c : words[0].toCharArray()) {
            pre[c - 'a']++;
        }
        for (String word : words) {
            for (char c : word.toCharArray()) {
                cur[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                pre[i] = Math.min(pre[i], cur[i]);
                cur[i] = 0;
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (pre[i]-- > 0) {
                list.add(String.valueOf((char)('a' + i)));
            }
        }
        return list;
    }
}