class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if (str1.length() < str2.length())
            return false;
        int j = 0;
        for (int i = 0; i < str1.length(); i++) {
            char a = str1.charAt(i);
            int a0 = a - 'a';
            int a1 = (a0 + 1) % 26;
            char b = str2.charAt(j);
            int b0 = b - 'a';
            if (a0 == b0 || a1 == b0)
                j++;
            if (j == str2.length())
                return true;
        }
        return j == str2.length();
    }
}