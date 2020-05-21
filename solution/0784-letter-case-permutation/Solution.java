class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        backtracking(ans, S, 0);
        return ans;
    }

    private void backtracking(List<String> ans, String S, int start) {
        ans.add(S);

        for (int i = start; i < S.length(); i++) {
            if (S.charAt(i) >= '0' && S.charAt(i) <= '9')
                continue;
            char ch = S.charAt(i);
            backtracking(ans, S.substring(0, i) + change(ch) + S.substring(i + 1), i + 1);
        }
    }
    
    private char change(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            return (char) (ch + 32);
        else
            return (char) (ch - 32);
    }
}
