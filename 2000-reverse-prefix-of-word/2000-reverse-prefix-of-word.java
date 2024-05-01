class Solution {
    public String reversePrefix(String word, char ch) {
        int i = 0;
        int n = word.length();
        while (i < n && word.charAt(i) != ch)
            i++;
        if (i == n)
            return word;
        StringBuilder res = new StringBuilder();
        int pos = i + 1;
        while (i >= 0) {
            res.append(word.charAt(i));
            i--;
        }
        if (pos < n)
            res.append(word.substring(pos));
        return res.toString();
    }
}