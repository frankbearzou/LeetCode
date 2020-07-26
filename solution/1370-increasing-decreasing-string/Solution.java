class Solution {
    public String sortString(String s) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            int i = (int)(ch - 'a');
            arr[i]++;
        }
        
        while (sb.length() != s.length()) {
            for (int i = 0; i < 26; i++) {
                if (arr[i] > 0) {
                    sb.append((char)('a' + i));
                    arr[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (arr[i] > 0) {
                    sb.append((char)('a' + i));
                    arr[i]--;
                }
            }
        }
        
        return sb.toString();
    }
}
