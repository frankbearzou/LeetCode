class Solution {
    public List<String> commonChars(String[] words) {
        int[] res = get(words[0]);
        for (int i = 1; i < words.length; i++) {
            int[] pre = res;
            int[] cur = get(words[i]);
            int[] temp = new int[26];
            for (int j = 0; j < 26; j++) {
                temp[j] = Math.min(pre[j], cur[j]);
            }
            res = temp;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (res[i]-- > 0) {
                list.add("" + (char)('a' + i));
            }
        }
        return list;
    }

    int[] get(String word) {
        int[] res = new int[26];
        for (char c : word.toCharArray())
            res[c - 'a']++;
        return res;
    }
}