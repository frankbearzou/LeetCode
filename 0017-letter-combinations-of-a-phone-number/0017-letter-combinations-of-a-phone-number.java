class Solution {
    String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return ans;
        backtracking(digits, 0, "");
        return ans;
    }

    void backtracking(String digits, int start, String path) {
        if (path.length() == digits.length()) {
            ans.add(new String(path));
            return;
        }
        for (int i = start; i < digits.length(); i++) {
            for (char c : letters[digits.charAt(i) - '2'].toCharArray()) {
                backtracking(digits, i + 1, path + c);
            }
        }
    }
}