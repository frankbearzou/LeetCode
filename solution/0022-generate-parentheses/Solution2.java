class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        backtracking("", 0, 0, n, combinations);
        return combinations;
    }

    public void backtracking(String str, int left, int right, int max, List<String> result) {
        if (str.length() == max * 2) {
            result.add(str);
            return;
        }
        if (left < max)
            backtracking(str + '(', left + 1, right, max, result);
        if (right < left)
            backtracking(str + ')', left, right + 1, max, result);
    }
}
