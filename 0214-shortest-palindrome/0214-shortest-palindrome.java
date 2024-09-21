class Solution {
    public String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, s.length() - i).equals(reverse.substring(i))) {
                return new StringBuilder(reverse.substring(0, i)).append(s).toString();
            }
        }
        return "";
    }
}