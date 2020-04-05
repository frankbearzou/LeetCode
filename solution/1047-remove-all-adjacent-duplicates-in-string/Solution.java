class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder(S);
        int len;
        
        do {
            len = sb.length();
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1))
                    sb.delete(i, i + 2);
            }
        } while (len != sb.length());
        
        return sb.toString();
    }
}
