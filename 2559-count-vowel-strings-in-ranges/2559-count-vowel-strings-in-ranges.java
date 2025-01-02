class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        List<Character> vowel = List.of('a', 'e', 'i', 'o', 'u');
        int n = words.length;
        int[] prefix = new int[n];
        int[] ans = new int[queries.length];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            if (vowel.contains(word.charAt(0)) && vowel.contains(word.charAt(word.length() - 1))) {
                if (i == 0) {
                    prefix[i] = 1;
                } else {
                    prefix[i] = prefix[i - 1] + 1;
                }
            } else {
                if (i > 0) {
                    prefix[i] = prefix[i - 1];
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int l = query[0];
            int r = query[1];
            if (l == 0 || r == 0) {
                ans[i] = prefix[r];
            } else {
                ans[i] = prefix[r] - prefix[l - 1];
            }
        }
        return ans;
    }
}