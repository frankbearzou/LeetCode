class Solution {
    public String boldWords(String[] words, String s) {
        int n = s.length();
        boolean[] mask = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (String word : words) {
                if (s.substring(i).startsWith(word)) {
                    for (int j = i; j < i + word.length(); j++) {
                        mask[j] = true;
                    }
                }
            }
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (mask[i] && (i == 0 || !mask[i - 1]))
                str.append("<b>");
            str.append(s.charAt(i));
            if (mask[i] && (i == n - 1 || !mask[i + 1]))
                str.append("</b>");
        }
        return str.toString();
    }
}