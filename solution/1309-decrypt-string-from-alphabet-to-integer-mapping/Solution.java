class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (index + 2 < s.length() && s.charAt(index + 2) == '#') {
                sb.append((char)('a' + Integer.parseInt(s.substring(index, index + 2)) - 1));
                index += 3;
            } else {
                sb.append((char)('a' + Integer.parseInt(s.substring(index, index + 1)) - 1));
                index++;
            }
        }
        return sb.toString();
    }
}
