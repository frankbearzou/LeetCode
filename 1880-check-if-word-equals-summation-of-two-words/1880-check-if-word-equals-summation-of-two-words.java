class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return convert(firstWord) + convert(secondWord) == convert(targetWord);
    }

    int convert(String str) {
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            n = n * 10 + (int)(str.charAt(i) - 'a');
        }
        return n;
    }
}