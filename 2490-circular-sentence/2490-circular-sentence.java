class Solution {
    public boolean isCircularSentence(String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1))
            return false;
        String[] split = sentence.split(" ");
        char ch = split[0].charAt(split[0].length() - 1);
        for (int i = 1; i < split.length; i++) {
            if (split[i].charAt(0) != ch)
                return false;
            ch = split[i].charAt(split[i].length() - 1);
        }
        return true;
    }
}