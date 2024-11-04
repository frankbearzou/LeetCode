class Solution {
    public String compressedString(String word) {
        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < word.length()) {
            int j = i;
            while (j + 1 < word.length() && word.charAt(i) == word.charAt(j + 1) && j - i < 8)
                j++;
            str.append(j - i + 1);
            str.append(word.charAt(i));
            i = j + 1;
        }
        return str.toString();
    }
}