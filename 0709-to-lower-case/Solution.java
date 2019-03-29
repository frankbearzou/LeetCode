class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.replace(i, i + 1, String.valueOf((char)(str.charAt(i) + 32)));
            }
        }
        return sb.toString();
    }
}
