class Solution {
    public String toGoatLatin(String sentence) {
        Set<Character> vowel = Set.of('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u');
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (String word : split) {
            if (!vowel.contains(word.charAt(0))) {
                word = word.substring(1) + word.charAt(0);
            }
            word = word + "ma";
            for (int j = 0; j < count; j++)
                word += "a";
            count++;
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }
}