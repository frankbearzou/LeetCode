class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() > sentence2.length())
            return areSentencesSimilar(sentence2, sentence1);
        String[] w1 = sentence1.split(" ");
        String[] w2 = sentence2.split(" ");
        int len1 = w1.length, len2 = w2.length;
        int start = 0, end1 = w1.length - 1, end2 = w2.length - 1;
        while (start < len1 && w1[start].equals(w2[start]))
            start++;
        while (end1 >= 0 && w1[end1].equals(w2[end2])) {
            end1--;
            end2--;
        }
        return start > end1;
    }
}