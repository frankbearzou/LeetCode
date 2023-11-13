class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> map = List.of("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return ans;
        backtracking(digits, 0, "", map, ans);
        return ans;
    }

    private void backtracking(String digits, int index, String str, List<String> map, List<String> ans) {
        if (str.length() == digits.length()) {
            ans.add(str);
        }
        for (int i = index; i < digits.length(); i++) {
            String letters = map.get(digits.charAt(i) - '0' - 2);
            for (int j = 0; j < letters.length(); j++) {
                backtracking(digits, i + 1, str + letters.charAt(j), map, ans);
            }
        }
    }
}