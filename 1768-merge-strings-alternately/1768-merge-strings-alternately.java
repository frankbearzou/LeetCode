class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int len = Math.min(word1.length(), word2.length());
        for (int i = 0; i < len; i++) {
            res.append(word1.charAt(i)).append(word2.charAt(i));
        }
        if (word1.length() > len)
            res.append(word1.substring(len));
        else
            res.append(word2.substring(len));
        return res.toString();
    }
}