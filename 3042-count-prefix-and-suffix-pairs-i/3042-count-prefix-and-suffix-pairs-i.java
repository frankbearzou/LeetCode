class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j]))
                    cnt++;
            }
        }
        return cnt;
    }

    boolean isPrefixAndSuffix(String str1, String str2) {
        if (str1.equals(str2))
            return true;
        if (str1.length() >= str2.length())
            return false;
        return str1.equals(str2.substring(0, str1.length())) && str1.equals(str2.substring(str2.length() - str1.length()));
    }
}