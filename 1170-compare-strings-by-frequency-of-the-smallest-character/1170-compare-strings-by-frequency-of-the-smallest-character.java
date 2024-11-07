class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] fqueries = new int[queries.length];
        int[] fwords = new int[words.length];
        for (int i = 0; i < queries.length; i++) {
            fqueries[i] = f(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            fwords[i] = f(words[i]);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int w : fwords) {
                if (fqueries[i] < w) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    int f(String word) {
        int[] map = new int[26];
        for (char c : word.toCharArray()) {
            int index = (int)(c - 'a');
            map[index]++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0)
                return map[i];
        }
        return 0;
    }
}