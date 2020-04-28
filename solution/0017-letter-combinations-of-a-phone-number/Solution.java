class Solution {
    private String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return ans;
        backtracking("", digits);
        return ans;
    }

    private void backtracking(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            ans.add(combination);
            return;
        }
        String letters = mapping[nextDigits.charAt(0) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            backtracking(combination + letters.charAt(i), nextDigits.substring(1));
        }
    }
}
