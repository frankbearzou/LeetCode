class Solution {
    public int maxRepeating(String sequence, String word) {
        int times = 0;
        for (int i = 1; i <= sequence.length() / word.length(); i++) {
            if (sequence.indexOf(construct(word, i)) != -1) {
                times = i;
            } else
                break;
        }
        return times;
    }

    String construct(String word, int times) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < times; i++) {
            res.append(word);
        }
        return res.toString();
    }
}