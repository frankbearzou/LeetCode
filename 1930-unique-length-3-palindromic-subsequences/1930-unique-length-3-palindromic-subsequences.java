class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> set = new HashSet<>();
        int[] prefix = new int[26];
        int[] postfix = new int[26];
        Arrays.fill(prefix, -1);
        Arrays.fill(postfix, -1);
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int index = arr[i] - 'a';
            if (prefix[index] == -1) {
                prefix[index] = i;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int index = arr[i] - 'a';
            if (postfix[index] == -1) {
                postfix[index] = i;
            }
        }
        for (int i = 0; i < 26; i++) {
            int first = prefix[i];
            int last = postfix[i];
            if (first != -1 && last != -1) {
                for (int j = first + 1; j < last; j++) {
                    char cur = (char)('a' + i);
                    StringBuilder sb = new StringBuilder();
                    String p = sb.append(cur).append(arr[j]).append(cur).toString();
                    set.add(p);
                }
            }
        }
        return set.size();
    }
}