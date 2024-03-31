class Solution {
    public String toGoatLatin(String sentence) {
        Set<Character> vowel = Set.of('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u');
        String[] split = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (String word : split) {
            if (!vowel.contains(word.charAt(0))) {
                sb.append(word.substring(1)).append(word.charAt(0));
            } else {
                sb.append(word);
            }
            sb.append("ma");
            for (int j = 0; j < count; j++)
                sb.append("a");
            count++;
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}